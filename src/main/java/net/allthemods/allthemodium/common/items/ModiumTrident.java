package net.allthemods.allthemodium.common.items;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Position;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Weapon;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import net.allthemods.allthemodium.common.entity.ThrownModiumTrident;

public class ModiumTrident extends TridentItem {
    
    public ModiumTrident(Properties properties) {
        super(properties
                .rarity(Rarity.EPIC)
                .fireResistant()
                .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
                .durability(Short.MAX_VALUE)
                .attributes(ModiumTrident.createAttributes())
                .component(DataComponents.TOOL, TridentItem.createToolProperties())
                .enchantable(1)
                .component(DataComponents.WEAPON, new Weapon(1))
        );
    }
    
    public static ItemAttributeModifiers createAttributes() {
        return ItemAttributeModifiers.builder()
                .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, 16.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ATTACK_SPEED, new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, -1.8F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .build();
    }
    
    @Override
    public int getUseDuration(ItemStack itemStack, LivingEntity user) {
        return 12000;
    }
    
    @Override
    public boolean releaseUsing(ItemStack stack, Level level, LivingEntity entity, int remaining) {
        if (!(entity instanceof Player player)) return false;
        
        int timeHeld = this.getUseDuration(stack, entity) - remaining;
        if (timeHeld < 10) return false;
        
        float riptideStrength = EnchantmentHelper.getTridentSpinAttackStrength(stack, player) * 1.5F;
        if (riptideStrength > 0.0F && (!player.isInWaterOrRain() || player.isPassenger())) return false;
        
        Holder<SoundEvent> sound = EnchantmentHelper.pickHighestLevel(stack, EnchantmentEffectComponents.TRIDENT_SOUND).orElse(SoundEvents.TRIDENT_THROW);
        player.awardStat(Stats.ITEM_USED.get(this));
        
        if (level instanceof ServerLevel serverLevel && riptideStrength == 0.0F) {
            ItemStack projectile = stack.consumeAndReturn(1, player);
            ThrownModiumTrident trident = Projectile.spawnProjectileFromRotation(ThrownModiumTrident::new, serverLevel, projectile, player, 0.0F, 3.5F, 1.0F);
            if (player.hasInfiniteMaterials()) trident.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
            level.playSound(null, trident, sound.value(), SoundSource.PLAYERS, 1.0F, 1.0F);
            return true;
        }
        
        if (riptideStrength <= 0.0F) return false;
        
        float yRot = player.getYRot();
        float xRot = player.getXRot();
        float xd = -Mth.sin(yRot * (float) (Math.PI / 180.0)) * Mth.cos(xRot * (float) (Math.PI / 180.0));
        float yd = -Mth.sin(xRot * (float) (Math.PI / 180.0));
        float zd = Mth.cos(yRot * (float) (Math.PI / 180.0)) * Mth.cos(xRot * (float) (Math.PI / 180.0));
        float dist = Mth.sqrt(xd * xd + yd * yd + zd * zd);
        xd *= riptideStrength / dist;
        yd *= riptideStrength / dist;
        zd *= riptideStrength / dist;
        player.push(xd, yd, zd);
        player.startAutoSpinAttack(10, 12.0F, stack);
        if (player.onGround()) player.move(MoverType.SELF, new Vec3(0.0, 1.1999999F, 0.0));
        
        level.playSound(null, player, sound.value(), SoundSource.PLAYERS, 1.0F, 1.0F);
        return true;
    }
    
    @Override
    public Projectile asProjectile(Level level, Position position, ItemStack stack, Direction direction) {
        ThrownModiumTrident trident = new ThrownModiumTrident(level, position.x(), position.y(), position.z(), stack.copyWithCount(1));
        trident.pickup = AbstractArrow.Pickup.ALLOWED;
        return trident;
    }
}
