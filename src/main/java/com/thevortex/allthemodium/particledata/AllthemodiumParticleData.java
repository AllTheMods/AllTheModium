package com.thevortex.allthemodium.particledata;

import java.util.Locale;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class AllthemodiumParticleData implements IParticleData {
	

	   public static final AllthemodiumParticleData ParticleDUST = new AllthemodiumParticleData((float)218/255,(float)165/255,(float)32/255, 1.0F);
	

	public static final IParticleData.IDeserializer<AllthemodiumParticleData> DESERIALIZER = new IParticleData.IDeserializer<AllthemodiumParticleData>() {
	      public AllthemodiumParticleData deserialize(ParticleType<AllthemodiumParticleData> particleTypeIn, StringReader reader) throws CommandSyntaxException {
	         reader.expect(' ');
	         float f = (float)reader.readDouble();
	         reader.expect(' ');
	         float f1 = (float)reader.readDouble();
	         reader.expect(' ');
	         float f2 = (float)reader.readDouble();
	         reader.expect(' ');
	         float f3 = (float)reader.readDouble();
	         return new AllthemodiumParticleData(f, f1, f2, f3);
	      }

	      public AllthemodiumParticleData read(ParticleType<AllthemodiumParticleData> particleTypeIn, PacketBuffer buffer) {
	         return new AllthemodiumParticleData(buffer.readFloat(), buffer.readFloat(), buffer.readFloat(), buffer.readFloat());
	      }
	   };
	   private final float red;
	   private final float green;
	   private final float blue;
	   private final float alpha;
	   
	   public AllthemodiumParticleData(float p_i47950_1_, float p_i47950_2_, float p_i47950_3_, float p_i47950_4_) {
		      this.red = p_i47950_1_;
		      this.green = p_i47950_2_;
		      this.blue = p_i47950_3_;
		      this.alpha = MathHelper.clamp(p_i47950_4_, 0.01F, 4.0F);
		   }


	   public void write(PacketBuffer buffer) {
	      buffer.writeFloat(this.red);
	      buffer.writeFloat(this.green);
	      buffer.writeFloat(this.blue);
	      buffer.writeFloat(this.alpha);
	   }

	   @SuppressWarnings("deprecation")
	public String getParameters() {
	      return String.format(Locale.ROOT, "%s %.2f %.2f %.2f %.2f", Registry.PARTICLE_TYPE.getKey(this.getType()), this.red, this.green, this.blue, this.alpha);
	   }

	   public ParticleType<RedstoneParticleData> getType() {
	      return ParticleTypes.DUST;
	   }

	   @OnlyIn(Dist.CLIENT)
	   public float getRed() {
	      return this.red;
	   }

	   @OnlyIn(Dist.CLIENT)
	   public float getGreen() {
	      return this.green;
	   }

	   @OnlyIn(Dist.CLIENT)
	   public float getBlue() {
	      return this.blue;
	   }

	   @OnlyIn(Dist.CLIENT)
	   public float getAlpha() {
	      return this.alpha;
	   }
	}