package com.thevortex.allthemodium.reference;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;
import mekanism.api.heat.IHeatCapacitor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.block.BlockModelShaper;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.PlayerItemInHandLayer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.client.gui.components.Button;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.joml.Matrix4f;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public final class RenderHelpers
{

    /**
     * Creates a default {@link ModelResourceLocation} with the TFC namespace using the {@link ModelResourceLocation#STANDALONE_VARIANT}.
     */
    public static ModelResourceLocation modelId(String id)
    {
        return ModelResourceLocation.standalone(Reference.atm(id));
    }

    public static ModelResourceLocation modelId(ResourceLocation id)
    {
        return ModelResourceLocation.standalone(id);
    }

    public static ModelLayerLocation layerId(String name)
    {
        return layerId(name, "bb_main");
    }

    /**
     * Creates {@link ModelLayerLocation} in the default manner
     */
    public static ModelLayerLocation layerId(String name, String part)
    {
        return new ModelLayerLocation(Reference.atm(name), part);
    }




    /**
     * Renders a fully textured, solid cuboid described by the provided {@link AABB}, usually obtained from {@link VoxelShape#bounds()}.
     * Texture widths (in pixels) are inferred to be 16 x the width of the quad, which matches normal block pixel texture sizes.
     */
    public static void renderTexturedCuboid(PoseStack poseStack, VertexConsumer buffer, TextureAtlasSprite sprite, int packedLight, int packedOverlay, AABB bounds)
    {
        renderTexturedCuboid(poseStack, buffer, sprite, packedLight, packedOverlay, (float) bounds.minX, (float) bounds.minY, (float) bounds.minZ, (float) bounds.maxX, (float) bounds.maxY, (float) bounds.maxZ);
    }

    public static void renderTexturedCuboid(PoseStack poseStack, VertexConsumer buffer, TextureAtlasSprite sprite, int packedLight, int packedOverlay, AABB bounds, int color)
    {
        renderTexturedCuboid(poseStack, buffer, sprite, packedLight, packedOverlay, (float) bounds.minX, (float) bounds.minY, (float) bounds.minZ, (float) bounds.maxX, (float) bounds.maxY, (float) bounds.maxZ, color);
    }

    /**
     * Renders a fully textured, solid cuboid described by the shape (minX, minY, minZ) x (maxX, maxY, maxZ).
     * Texture widths (in pixels) are inferred to be 16 x the width of the quad, which matches normal block pixel texture sizes.
     */
    public static void renderTexturedCuboid(PoseStack poseStack, VertexConsumer buffer, TextureAtlasSprite sprite, int packedLight, int packedOverlay, float minX, float minY, float minZ, float maxX, float maxY, float maxZ)
    {
        renderTexturedCuboid(poseStack, buffer, sprite, packedLight, packedOverlay, minX, minY, minZ, maxX, maxY, maxZ, 16f * (maxX - minX), 16f * (maxY - minY), 16f * (maxZ - minZ), true);
    }

    public static void renderTexturedCuboid(PoseStack poseStack, VertexConsumer buffer, TextureAtlasSprite sprite, int packedLight, int packedOverlay, float minX, float minY, float minZ, float maxX, float maxY, float maxZ, boolean doShade)
    {
        renderTexturedCuboid(poseStack, buffer, sprite, packedLight, packedOverlay, minX, minY, minZ, maxX, maxY, maxZ, 16f * (maxX - minX), 16f * (maxY - minY), 16f * (maxZ - minZ), doShade);
    }

    public static void renderTexturedCuboid(PoseStack poseStack, VertexConsumer buffer, TextureAtlasSprite sprite, int packedLight, int packedOverlay, float minX, float minY, float minZ, float maxX, float maxY, float maxZ, int color)
    {
        renderTexturedCuboid(poseStack, buffer, sprite, packedLight, packedOverlay, minX, minY, minZ, maxX, maxY, maxZ, 16f * (maxX - minX), 16f * (maxY - minY), 16f * (maxZ - minZ), color);
    }

    /**
     * Renders a fully textured, solid cuboid described by the shape (minX, minY, minZ) x (maxX, maxY, maxZ).
     * (xPixels, yPixels, zPixels) represent pixel widths for each side, which are used for texture (u, v) purposes.
     */
    public static void renderTexturedCuboid(PoseStack poseStack, VertexConsumer buffer, TextureAtlasSprite sprite, int packedLight, int packedOverlay, float minX, float minY, float minZ, float maxX, float maxY, float maxZ, float xPixels, float yPixels, float zPixels, boolean doShade)
    {
        renderTexturedQuads(poseStack, buffer, sprite, packedLight, packedOverlay, getXVertices(minX, minY, minZ, maxX, maxY, maxZ), zPixels, yPixels, 1, 0, 0, doShade);
        renderTexturedQuads(poseStack, buffer, sprite, packedLight, packedOverlay, getYVertices(minX, minY, minZ, maxX, maxY, maxZ), zPixels, xPixels, 0, 1, 0, doShade);
        renderTexturedQuads(poseStack, buffer, sprite, packedLight, packedOverlay, getZVertices(minX, minY, minZ, maxX, maxY, maxZ), xPixels, yPixels, 0, 0, 1, doShade);
    }

    public static void renderTexturedCuboid(PoseStack poseStack, VertexConsumer buffer, TextureAtlasSprite sprite, int packedLight, int packedOverlay, float minX, float minY, float minZ, float maxX, float maxY, float maxZ, float xPixels, float yPixels, float zPixels, int color)
    {
        renderTexturedQuads(poseStack, buffer, sprite, packedLight, packedOverlay, getXVertices(minX, minY, minZ, maxX, maxY, maxZ), zPixels, yPixels, 1, 0, 0, color);
        renderTexturedQuads(poseStack, buffer, sprite, packedLight, packedOverlay, getYVertices(minX, minY, minZ, maxX, maxY, maxZ), zPixels, xPixels, 0, 1, 0, color);
        renderTexturedQuads(poseStack, buffer, sprite, packedLight, packedOverlay, getZVertices(minX, minY, minZ, maxX, maxY, maxZ), xPixels, yPixels, 0, 0, 1, color);
    }

    /**
     * <pre>
     *  Q------Q.  ^ y
     *  |`.    | `.|
     *  |  `Q--+---Q--> x = maxY
     *  |   |  |   |
     *  P---+--P.  |
     *   `. |    `.|
     *     `P------P = minY
     * </pre>
     *
     * Renders a fully textured, solid trapezoidal cuboid described by the plane P, the plane Q, minY, and maxY.
     * (xPixels, yPixels, zPixels) represent pixel widths for each side, which are used for texture (u, v) purposes.
     */
    public static void renderTexturedTrapezoidalCuboid(PoseStack poseStack, VertexConsumer buffer, TextureAtlasSprite sprite, int packedLight, int packedOverlay, float pMinX, float pMaxX, float pMinZ, float pMaxZ, float qMinX, float qMaxX, float qMinZ, float qMaxZ, float minY, float maxY, float xPixels, float yPixels, float zPixels, boolean invertNormal)
    {
        renderTexturedQuads(poseStack, buffer, sprite, packedLight, packedOverlay, getTrapezoidalCuboidXVertices(pMinX, pMaxX, pMinZ, pMaxZ, qMinX, qMaxX, qMinZ, qMaxZ, minY, maxY), zPixels, yPixels, invertNormal ? 0 : 1, 0, invertNormal ? 1 : 0, true);
        renderTexturedQuads(poseStack, buffer, sprite, packedLight, packedOverlay, getTrapezoidalCuboidYVertices(pMinX, pMaxX, pMinZ, pMaxZ, qMinX, qMaxX, qMinZ, qMaxZ, minY, maxY), zPixels, xPixels, 0, 1, 0, true);
        renderTexturedQuads(poseStack, buffer, sprite, packedLight, packedOverlay, getTrapezoidalCuboidZVertices(pMinX, pMaxX, pMinZ, pMaxZ, qMinX, qMaxX, qMinZ, qMaxZ, minY, maxY), xPixels, yPixels, invertNormal ? 1 : 0, 0, invertNormal ? 0 : 1, true);
    }

    /**
     * Renders a single textured quad, either by itself or as part of a larger cuboid construction.
     * {@code vertices} must be a set of vertices, usually obtained through {@link #getXVertices(float, float, float, float, float, float)}, {@link #getYVertices(float, float, float, float, float, float)}, or {@link #getZVertices(float, float, float, float, float, float)}. Parameters are (x, y, z, u, v, normalSign) for each vertex.
     * (normalX, normalY, normalZ) are the normal vectors (positive), for the quad. For example, for an X quad, this will be (1, 0, 0).
     *
     * @param vertices The vertices.
     * @param uSize    The horizontal (u) texture size of the quad, in pixels.
     * @param vSize    The vertical (v) texture size of the quad, in pixels.
     */
    public static void renderTexturedQuads(PoseStack poseStack, VertexConsumer buffer, TextureAtlasSprite sprite, int packedLight, int packedOverlay, float[][] vertices, float uSize, float vSize, float normalX, float normalY, float normalZ, boolean doShade)
    {
        for (float[] v : vertices)
        {
            renderTexturedVertex(poseStack, buffer, packedLight, packedOverlay, v[0], v[1], v[2], sprite.getU(v[3] * uSize * 1f / 16f), sprite.getV(v[4] * vSize * 1f / 16f), v[5] * normalX, v[5] * normalY, v[5] * normalZ, doShade);
        }
    }

    public static void renderTexturedQuads(PoseStack poseStack, VertexConsumer buffer, TextureAtlasSprite sprite, int packedLight, int packedOverlay, float[][] vertices, float uSize, float vSize, float normalX, float normalY, float normalZ, int color)
    {
        for (float[] v : vertices)
        {
            renderTexturedVertex(poseStack, buffer, packedLight, packedOverlay, v[0], v[1], v[2], sprite.getU(v[3] * uSize * 1f / 16f), sprite.getV(v[4] * vSize * 1f / 16f), v[5] * normalX, v[5] * normalY, v[5] * normalZ, color);
        }
    }

    public static void renderTexturedVertex(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float x, float y, float z, float u, float v, float normalX, float normalY, float normalZ)
    {
        renderTexturedVertex(poseStack, buffer, packedLight, packedOverlay, x, y, z, u, v, normalX, normalY, normalZ, true);
    }

    /**
     * Renders a single vertex as part of a quad.
     * <ul>
     *     <li>(x, y, z) describe the position of the vertex.</li>
     *     <li>(u, v) describe the texture coordinates, typically will be a number of pixels (i.e. 16x something)</li>
     *     <li>(normalX, normalY, normalZ) describe the normal vector to the quad.</li>
     * </ul>
     */
    public static void renderTexturedVertex(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float x, float y, float z, float u, float v, float normalX, float normalY, float normalZ, boolean doShade)
    {
        final float shade = doShade ? getShade(normalX, normalY, normalZ) : 1f;
        final int color = FastColor.ARGB32.colorFromFloat(1f, shade, shade, shade);
        renderTexturedVertex(poseStack, buffer, packedLight, packedOverlay, x, y, z, u, v, normalX, normalY, normalZ, color);
    }

    public static void renderTexturedVertex(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float x, float y, float z, float u, float v, float normalX, float normalY, float normalZ, int color)
    {
        buffer.addVertex(poseStack.last().pose(), x, y, z)
                .setColor(color)
                .setUv(u, v)
                .setLight(packedLight)
                .setOverlay(packedOverlay)
                .setNormal(poseStack.last(), normalX, normalY, normalZ);
    }

    /**
     * Converts a potentially angled normal into the 'nearest' directional step. Could potentially be reimplemented as an inverse lerp.
     */
    public static float getShade(float normalX, float normalY, float normalZ)
    {
        return getShadeForStep(Math.round(normalX), Math.round(normalY), Math.round(normalZ));
    }

    /**
     * Returns the static diffuse shade by MC for each directional face. The color value of a vertex should be multiplied by this.
     * Reimplements {@link net.minecraft.client.multiplayer.ClientLevel#getShade(Direction, boolean)}
     */
    public static float getShadeForStep(int normalX, int normalY, int normalZ)
    {
        if (normalY == 1) return 1f;
        if (normalY == -1) return 0.5f;
        if (normalZ != 0) return 0.8f;
        if (normalX != 0) return 0.6f;
        return 1f;
    }

    /**
     * <pre>
     *  O------P.  ^ y
     *  |`.    | `.|
     *  |  `O--+---P--> x
     *  |   |  |   |
     *  O---+--P.  |
     *   `. |    `.|
     *     `O------P
     * </pre>
     *
     * @return A collection of vertices for two parallel faces of a cube, facing outwards, defined by (minX, minY, minZ) x (maxX, maxY, maxZ). Or the faces O and P in the above art
     */
    public static float[][] getXVertices(float minX, float minY, float minZ, float maxX, float maxY, float maxZ)
    {
        return new float[][] {
                {minX, minY, minZ, 0, 1, 1}, // +X
                {minX, minY, maxZ, 1, 1, 1},
                {minX, maxY, maxZ, 1, 0, 1},
                {minX, maxY, minZ, 0, 0, 1},

                {maxX, minY, maxZ, 1, 0, -1}, // -X
                {maxX, minY, minZ, 0, 0, -1},
                {maxX, maxY, minZ, 0, 1, -1},
                {maxX, maxY, maxZ, 1, 1, -1}
        };
    }

    /**
     * <pre>
     *  O------O.  ^ y
     *  |`.    | `.|
     *  |  `O--+---O--> x
     *  |   |  |   |
     *  P---+--P.  |
     *   `. |    `.|
     *     `P------P
     * </pre>
     *
     * @return A collection of vertices for two parallel faces of a cube, facing outwards, defined by (minX, minY, minZ) x (maxX, maxY, maxZ). Or the faces O and P in the above art
     */
    public static float[][] getYVertices(float minX, float minY, float minZ, float maxX, float maxY, float maxZ)
    {
        return new float[][] {
                {minX, maxY, minZ, 0, 1, 1}, // +Y
                {minX, maxY, maxZ, 1, 1, 1},
                {maxX, maxY, maxZ, 1, 0, 1},
                {maxX, maxY, minZ, 0, 0, 1},

                {minX, minY, maxZ, 1, 0, -1}, // -Y
                {minX, minY, minZ, 0, 0, -1},
                {maxX, minY, minZ, 0, 1, -1},
                {maxX, minY, maxZ, 1, 1, -1}
        };
    }

    /**
     * <pre>
     *  O------O.  ^ y
     *  |`.    | `.|
     *  |  `P--+---P--> x
     *  |   |  |   |
     *  O---+--O.  |
     *   `. |    `.|
     *     `P------P
     * </pre>
     *
     * @return A collection of vertices for two parallel faces of a cube, facing outwards, defined by (minX, minY, minZ) x (maxX, maxY, maxZ). Or the faces O and P in the above art
     */
    public static float[][] getZVertices(float minX, float minY, float minZ, float maxX, float maxY, float maxZ)
    {
        return new float[][] {
                {maxX, minY, minZ, 0, 1, 1}, // +Z
                {minX, minY, minZ, 1, 1, 1},
                {minX, maxY, minZ, 1, 0, 1},
                {maxX, maxY, minZ, 0, 0, 1},

                {minX, minY, maxZ, 1, 0, -1}, // -Z
                {maxX, minY, maxZ, 0, 0, -1},
                {maxX, maxY, maxZ, 0, 1, -1},
                {minX, maxY, maxZ, 1, 1, -1}
        };
    }

    /**
     * <pre>
     *  P------P.  ^ y
     *  |`.    | `.|
     *  |  `+--+---+--> x
     *  |   |  |   |
     *  +---+--+.  |
     *   `. |    `.|
     *     `P------P
     * </pre>
     *
     * @return A collection of vertices for both sides of one of the diagonal faces of a cube defined by (minX, minY, minZ) x (maxX, maxY, maxZ). Or both sides of the face defined by vertices P in the above art.
     */
    public static float[][] getDiagonalPlaneVertices(float x1, float y1, float z1, float x2, float y2, float z2, float u1, float v1, float u2, float v2)
    {
        return new float[][] {
                {x1, y1, z1, u1, v1},
                {x2, y1, z1, u2, v1},
                {x2, y2, z2, u2, v2},
                {x1, y2, z2, u1, v2},

                {x2, y1, z1, u2, v1},
                {x1, y1, z1, u1, v1},
                {x1, y2, z2, u1, v2},
                {x2, y2, z2, u2, v2}
        };
    }

    /**
     * <pre>
     *  Q------Q.  ^ y
     *  |`.    | `.|
     *  |  `Q--+---Q--> x = maxY
     *  |   |  |   |
     *  P---+--P.  |
     *   `. |    `.|
     *     `P------P = minY
     * </pre>
     *
     * @return A collection of vertices for the positive and negative X outward faces of the above trapezoidal cuboid, defined by the plane P, and the plane Q, minY, and maxY.
     */
    public static float[][] getTrapezoidalCuboidXVertices(float pMinX, float pMaxX, float pMinZ, float pMaxZ, float qMinX, float qMaxX, float qMinZ, float qMaxZ, float minY, float maxY)
    {
        return new float[][] {
                {pMinX, minY, pMinZ, 0, 1, 1}, // +X
                {pMinX, minY, pMaxZ, 1, 1, 1},
                {qMinX, maxY, qMaxZ, 1, 0, 1},
                {qMinX, maxY, qMinZ, 0, 0, 1},

                {pMaxX, minY, pMaxZ, 1, 0, -1}, // -X
                {pMaxX, minY, pMinZ, 0, 0, -1},
                {qMaxX, maxY, qMinZ, 0, 1, -1},
                {qMaxX, maxY, qMaxZ, 1, 1, -1},
        };
    }

    /**
     * <pre>
     *  Q------Q.  ^ y
     *  |`.    | `.|
     *  |  `Q--+---Q--> x = maxY
     *  |   |  |   |
     *  P---+--P.  |
     *   `. |    `.|
     *     `P------P = minY
     * </pre>
     *
     * @return A collection of vertices for the positive and negative Y outward faces of the above trapezoidal cuboid, defined by the plane P, and the plane Q, minY, and maxY.
     */
    public static float[][] getTrapezoidalCuboidYVertices(float pMinX, float pMaxX, float pMinZ, float pMaxZ, float qMinX, float qMaxX, float qMinZ, float qMaxZ, float minY, float maxY)
    {
        return new float[][] {
                {qMinX, maxY, qMinZ, 0, 1, 1}, // +Y
                {qMinX, maxY, qMaxZ, 1, 1, 1},
                {qMaxX, maxY, qMaxZ, 1, 0, 1},
                {qMaxX, maxY, qMinZ, 0, 0, 1},

                {pMinX, minY, pMaxZ, 1, 0, -1}, // -Y
                {pMinX, minY, pMinZ, 0, 0, -1},
                {pMaxX, minY, pMinZ, 0, 1, -1},
                {pMaxX, minY, pMaxZ, 1, 1, -1},
        };
    }

    /**
     * <pre>
     *  Q------Q.  ^ y
     *  |`.    | `.|
     *  |  `Q--+---Q--> x = maxY
     *  |   |  |   |
     *  P---+--P.  |
     *   `. |    `.|
     *     `P------P = minY
     * </pre>
     *
     * @return A collection of vertices for the positive and negative X outward faces of the above trapezoidal cuboid, defined by the plane P, and the plane Q, minY, and maxY.
     */
    public static float[][] getTrapezoidalCuboidZVertices(float pMinX, float pMaxX, float pMinZ, float pMaxZ, float qMinX, float qMaxX, float qMinZ, float qMaxZ, float minY, float maxY)
    {
        return new float[][] {
                {pMaxX, minY, pMinZ, 0, 1, 1}, // +Z
                {pMinX, minY, pMinZ, 1, 1, 1},
                {qMinX, maxY, qMinZ, 1, 0, 1},
                {qMaxX, maxY, qMinZ, 0, 0, 1},

                {pMinX, minY, pMaxZ, 1, 0, -1}, // -Z
                {pMaxX, minY, pMaxZ, 0, 0, -1},
                {qMaxX, maxY, qMaxZ, 0, 1, -1},
                {qMinX, maxY, qMaxZ, 1, 1, -1}
        };
    }

    public static void setShaderColor(int color)
    {
        setColor(RenderSystem::setShaderColor, color);
    }

    public static void setShaderColor(GuiGraphics graphics, int color)
    {
        setColor(graphics::setColor, color);
    }

    private static void setColor(ARGBColorProvider provider, int color)
    {
        final float a = ((color >> 24) & 0xFF) / 255f;
        final float r = ((color >> 16) & 0xFF) / 255f;
        final float g = ((color >> 8) & 0xFF) / 255f;
        final float b = ((color) & 0xFF) / 255f;

        provider.setColor(r, g, b, a);
    }

    interface ARGBColorProvider
    {
        void setColor(float alpha, float red, float green, float blue);
    }





    public static ModelPart bakeSimple(EntityRendererProvider.Context context, String layerName)
    {
        return context.bakeLayer(layerId(layerName));
    }

    public static float itemTimeRotation()
    {
        return (float) (360.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);
    }






    private static void renderTexturedFace(PoseStack.Pose pose, VertexConsumer buffer, int color, float minX, float minZ, float maxX, float maxZ, float y, int packedOverlay, int packedLight, TextureAtlasSprite sprite)
    {
        buffer.addVertex(pose, minX, y, minZ).setColor(color).setUv(sprite.getU(minX), sprite.getV(minZ)).setOverlay(packedOverlay).setLight(packedLight).setNormal(pose, 0, 1, 0);
        buffer.addVertex(pose, minX, y, maxZ).setColor(color).setUv(sprite.getU(minX), sprite.getV(maxZ)).setOverlay(packedOverlay).setLight(packedLight).setNormal(pose, 0, 1, 0);
        buffer.addVertex(pose, maxX, y, maxZ).setColor(color).setUv(sprite.getU(maxX), sprite.getV(maxZ)).setOverlay(packedOverlay).setLight(packedLight).setNormal(pose, 0, 1, 0);
        buffer.addVertex(pose, maxX, y, minZ).setColor(color).setUv(sprite.getU(maxX), sprite.getV(minX)).setOverlay(packedOverlay).setLight(packedLight).setNormal(pose, 0, 1, 0);
    }



    /**
     * Copied from {@link GuiGraphics#blit(ResourceLocation, int, int, int, int, int, int)} but with explicit arguments for {@code minU, maxU, minV, maxV}.
     */
    public static void blit(GuiGraphics stack, int x, int y, int width, int height, float minU, float maxU, float minV, float maxV)
    {
        blit(stack.pose().last().pose(), x, x + width, y, y + height, 0, minU, maxU, minV, maxV);
    }



    public static void blit(Matrix4f pose, int x1, int x2, int y1, int y2, int blitOffset, float minU, float maxU, float minV, float maxV)
    {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        final BufferBuilder buffer = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        buffer.addVertex(pose, x1, y2, blitOffset).setUv(minU, maxV);
        buffer.addVertex(pose, x2, y2, blitOffset).setUv(maxU, maxV);
        buffer.addVertex(pose, x2, y1, blitOffset).setUv(maxU, minV);
        buffer.addVertex(pose, x1, y1, blitOffset).setUv(minU, minV);
        BufferUploader.drawWithShader(buffer.buildOrThrow());
    }

    public static boolean isInside(int mouseX, int mouseY, int leftX, int topY, int width, int height)
    {
        return mouseX >= leftX && mouseX <= leftX + width && mouseY >= topY && mouseY <= topY + height;
    }

    private static float calculateTilt(float pitch)
    {
        final float deg = Mth.clamp(1.0F - pitch / 45.0F + 0.1F, 0.0F, 1.0F) * (float) Math.PI;
        return -Mth.cos(deg) * 0.5F + 0.5F;
    }

    private static void renderMapHand(Minecraft mc, PoseStack poseStack, MultiBufferSource source, int combinedLight, HumanoidArm arm)
    {
        assert mc.player != null;

        final PlayerRenderer playerRenderer = (PlayerRenderer) mc.getEntityRenderDispatcher().<AbstractClientPlayer>getRenderer(mc.player);
        poseStack.pushPose();
        final float side = arm == HumanoidArm.RIGHT ? 1.0F : -1.0F;
        poseStack.mulPose(Axis.YP.rotationDegrees(92.0F));
        poseStack.mulPose(Axis.XP.rotationDegrees(45.0F));
        float degrees = side * -41.0F + calculateArmMovement(mc.player);
        poseStack.mulPose(Axis.ZP.rotationDegrees(degrees)); // tfc: jiggle the arms
        poseStack.translate(side * 0.3D, -1.1D, 0.45D);
        if (arm == HumanoidArm.RIGHT)
        {
            playerRenderer.renderRightHand(poseStack, source, combinedLight, mc.player);
        }
        else
        {
            playerRenderer.renderLeftHand(poseStack, source, combinedLight, mc.player);
        }
        poseStack.popPose();
    }



    private static float calculateArmMovement(LocalPlayer player)
    {
        final float degrees = player.getUseItemRemainingTicks() * (float) Math.PI / 10F;
        if (degrees > 0f)
        {
            return 10f * Mth.cos(degrees);
        }
        return 0f;
    }



}