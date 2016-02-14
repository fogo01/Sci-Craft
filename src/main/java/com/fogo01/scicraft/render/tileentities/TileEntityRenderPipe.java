package com.fogo01.scicraft.render.tileentities;

import com.fogo01.scicraft.reference.Reference;
import com.fogo01.scicraft.tileentity.TileEntityPipe;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

public class TileEntityRenderPipe extends TileEntitySpecialRenderer {
    ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":textures/models/Pipe.png");
    float pixel = 1/16F;
    boolean drawInside = true;

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double translationX, double translationY, double translationZ, float f) {
        GL11.glTranslated(translationX, translationY, translationZ);
        GL11.glDisable(GL11.GL_LIGHTING);
        this.bindTexture(texture);

        TileEntityPipe pipe = (TileEntityPipe)tileEntity;
        if (!pipe.onlyOneOpposite(pipe.connections)) {
            drawCore(tileEntity);
            for (int i = 0; i < pipe.connections.length; i++) {
                if (pipe.connections[i] != null)
                    drawConnection(pipe.connections[i]);
            }
        } else {
            for (int i = 0; i < pipe.connections.length; i++) {
                if (pipe.connections[i] != null) {
                    drawStraight(pipe.connections[i]);
                    break;
                }
            }
        }
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glTranslated(-translationX, -translationY, -translationZ);
    }

    public void drawStraight(ForgeDirection direction) {
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();{
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            if (direction == ForgeDirection.UP || direction == ForgeDirection.DOWN) {
                //Rotate
            } else if (direction == ForgeDirection.NORTH || direction == ForgeDirection.SOUTH) {
                GL11.glRotatef(90F, 1F, 0F, 0F);
            }else if (direction == ForgeDirection.EAST || direction == ForgeDirection.WEST) {
                GL11.glRotatef(90F, 0F, 0F, 1F);
            }
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

            tessellator.addVertexWithUV(5*pixel, 0, 5*pixel, 0*pixel, 6*pixel);
            tessellator.addVertexWithUV(5*pixel, 1, 5*pixel, 16*pixel, 6*pixel);
            tessellator.addVertexWithUV(1-5*pixel, 1, 5*pixel, 16*pixel, 0*pixel);
            tessellator.addVertexWithUV(1-5*pixel, 0, 5*pixel, 0*pixel, 0*pixel);

            tessellator.addVertexWithUV(1-5*pixel, 0, 5*pixel, 0*pixel, 6*pixel);
            tessellator.addVertexWithUV(1-5*pixel, 1, 5*pixel, 16*pixel, 6*pixel);
            tessellator.addVertexWithUV(1-5*pixel, 1, 1-5*pixel, 16*pixel, 0*pixel);
            tessellator.addVertexWithUV(1-5*pixel, 0, 1-5*pixel, 0*pixel, 0*pixel);

            tessellator.addVertexWithUV(1-5*pixel, 0, 1-5*pixel, 0*pixel, 6*pixel);
            tessellator.addVertexWithUV(1-5*pixel, 1, 1-5*pixel, 16*pixel, 6*pixel);
            tessellator.addVertexWithUV(5*pixel, 1, 1-5*pixel, 16*pixel, 0*pixel);
            tessellator.addVertexWithUV(5*pixel, 0, 1-5*pixel, 0*pixel, 0*pixel);

            tessellator.addVertexWithUV(5*pixel, 0, 1-5*pixel, 0*pixel, 6*pixel);
            tessellator.addVertexWithUV(5*pixel, 1, 1-5*pixel, 16*pixel, 6*pixel);
            tessellator.addVertexWithUV(5*pixel, 1, 5*pixel, 16*pixel, 0*pixel);
            tessellator.addVertexWithUV(5*pixel, 0, 5*pixel, 0*pixel, 0*pixel);

            if(drawInside){
                tessellator.addVertexWithUV(5*pixel, 0, 1-6*pixel, 0*pixel, 6*pixel);
                tessellator.addVertexWithUV(5*pixel, 1, 1-6*pixel, 16*pixel, 6*pixel);
                tessellator.addVertexWithUV(1-5*pixel, 1, 1-6*pixel, 16*pixel, 0*pixel);
                tessellator.addVertexWithUV(1-5*pixel, 0, 1-6*pixel, 0*pixel, 0*pixel);

                tessellator.addVertexWithUV(6*pixel, 0, 5*pixel, 0*pixel, 6*pixel);
                tessellator.addVertexWithUV(6*pixel, 1, 5*pixel, 16*pixel, 6*pixel);
                tessellator.addVertexWithUV(6*pixel, 1, 1-5*pixel, 16*pixel, 0*pixel);
                tessellator.addVertexWithUV(6*pixel, 0, 1-5*pixel, 0*pixel, 0*pixel);

                tessellator.addVertexWithUV(1-5*pixel, 0, 6*pixel, 0*pixel, 6*pixel);
                tessellator.addVertexWithUV(1-5*pixel, 1, 6*pixel, 16*pixel, 6*pixel);
                tessellator.addVertexWithUV(5*pixel, 1, 6*pixel, 16*pixel, 0*pixel);
                tessellator.addVertexWithUV(5*pixel, 0, 6*pixel, 0*pixel, 0*pixel);

                tessellator.addVertexWithUV(1-6*pixel, 0, 1-5*pixel, 0*pixel, 6*pixel);
                tessellator.addVertexWithUV(1-6*pixel, 1, 1-5*pixel, 16*pixel, 6*pixel);
                tessellator.addVertexWithUV(1-6*pixel, 1, 5*pixel, 16*pixel, 0*pixel);
                tessellator.addVertexWithUV(1-6*pixel, 0, 5*pixel, 0*pixel, 0*pixel);
            }
        }
        tessellator.draw();
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        if (direction == ForgeDirection.UP || direction == ForgeDirection.DOWN) {
            //Rotate
        } else if (direction == ForgeDirection.NORTH || direction == ForgeDirection.SOUTH) {
            GL11.glRotatef(-90F, 1F, 0F, 0F);
        }else if (direction == ForgeDirection.EAST || direction == ForgeDirection.WEST) {
            GL11.glRotatef(-90F, 0F, 0F, 1F);
        }
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
    }

    public void drawConnection(ForgeDirection direction) {
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();{
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            if (direction == ForgeDirection.UP) {
                //Rotate
            } else if (direction == ForgeDirection.DOWN) {
                GL11.glRotatef(180F, 1F, 0F, 0F);
            } else if (direction == ForgeDirection.NORTH) {
                GL11.glRotatef(-90F, 1F, 0F, 0F);
            } else if (direction == ForgeDirection.SOUTH) {
                GL11.glRotatef(90F, 1F, 0F, 0F);
            } else if (direction == ForgeDirection.EAST) {
                GL11.glRotatef(-90F, 0F, 0F, 1F);
            } else if (direction == ForgeDirection.WEST) {
                GL11.glRotatef(90F, 0F, 0F, 1F);
            }
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

            tessellator.addVertexWithUV(5*pixel, 1-5*pixel, 5*pixel, 6*pixel, 12*pixel);
            tessellator.addVertexWithUV(5*pixel, 17*pixel, 5*pixel, 12*pixel, 12*pixel);
            tessellator.addVertexWithUV(1-5*pixel, 17*pixel, 5*pixel, 12*pixel, 6*pixel);
            tessellator.addVertexWithUV(1-5*pixel, 1-5*pixel, 5*pixel, 6*pixel, 6*pixel);

            tessellator.addVertexWithUV(1-5*pixel, 1-5*pixel, 5*pixel, 6*pixel, 12*pixel);
            tessellator.addVertexWithUV(1-5*pixel, 17*pixel, 5*pixel, 12*pixel, 12*pixel);
            tessellator.addVertexWithUV(1-5*pixel, 17*pixel, 1-5*pixel, 12*pixel, 6*pixel);
            tessellator.addVertexWithUV(1-5*pixel, 1-5*pixel, 1-5*pixel, 6*pixel, 6*pixel);

            tessellator.addVertexWithUV(1-5*pixel, 1-5*pixel, 1-5*pixel, 6*pixel, 12*pixel);
            tessellator.addVertexWithUV(1-5*pixel, 17*pixel, 1-5*pixel, 12*pixel, 12*pixel);
            tessellator.addVertexWithUV(5*pixel, 17*pixel, 1-5*pixel, 12*pixel, 6*pixel);
            tessellator.addVertexWithUV(5*pixel, 1-5*pixel, 1-5*pixel, 6*pixel, 6*pixel);

            tessellator.addVertexWithUV(5*pixel, 1-5*pixel, 1-5*pixel, 6*pixel, 12*pixel);
            tessellator.addVertexWithUV(5*pixel, 17*pixel, 1-5*pixel, 12*pixel, 12*pixel);
            tessellator.addVertexWithUV(5*pixel, 17*pixel, 5*pixel, 12*pixel, 6*pixel);
            tessellator.addVertexWithUV(5*pixel, 1-5*pixel, 5*pixel, 6*pixel, 6*pixel);

            if(drawInside){
                tessellator.addVertexWithUV(5*pixel, 1-5*pixel, 1-6*pixel, 6*pixel, 12*pixel);
                tessellator.addVertexWithUV(5*pixel, 17*pixel, 1-6*pixel, 12*pixel, 12*pixel);
                tessellator.addVertexWithUV(1-5*pixel, 17*pixel, 1-6*pixel, 12*pixel, 6*pixel);
                tessellator.addVertexWithUV(1-5*pixel, 1-5*pixel, 1-6*pixel, 6*pixel, 6*pixel);

                tessellator.addVertexWithUV(6*pixel, 1-5*pixel, 5*pixel, 6*pixel, 12*pixel);
                tessellator.addVertexWithUV(6*pixel, 17*pixel, 5*pixel, 12*pixel, 12*pixel);
                tessellator.addVertexWithUV(6*pixel, 17*pixel, 1-5*pixel, 12*pixel, 6*pixel);
                tessellator.addVertexWithUV(6*pixel, 1-5*pixel, 1-5*pixel, 6*pixel, 6*pixel);

                tessellator.addVertexWithUV(1-5*pixel, 1-5*pixel, 6*pixel, 6*pixel, 12*pixel);
                tessellator.addVertexWithUV(1-5*pixel, 17*pixel, 6*pixel, 12*pixel, 12*pixel);
                tessellator.addVertexWithUV(5*pixel, 17*pixel, 6*pixel, 12*pixel, 6*pixel);
                tessellator.addVertexWithUV(5*pixel, 1-5*pixel, 6*pixel, 6*pixel, 6*pixel);

                tessellator.addVertexWithUV(1-6*pixel, 1-5*pixel, 1-5*pixel, 6*pixel, 12*pixel);
                tessellator.addVertexWithUV(1-6*pixel, 17*pixel, 1-5*pixel, 12*pixel, 12*pixel);
                tessellator.addVertexWithUV(1-6*pixel, 17*pixel, 5*pixel, 12*pixel, 6*pixel);
                tessellator.addVertexWithUV(1-6*pixel, 1-5*pixel, 5*pixel, 6*pixel, 6*pixel);
            }
        }
        tessellator.draw();
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        if (direction == ForgeDirection.UP) {
            //Rotate
        } else if (direction == ForgeDirection.DOWN) {
            GL11.glRotatef(-180F, 1F, 0F, 0F);
        } else if (direction == ForgeDirection.NORTH) {
            GL11.glRotatef(90F, 1F, 0F, 0F);
        } else if (direction == ForgeDirection.SOUTH) {
            GL11.glRotatef(-90F, 1F, 0F, 0F);
        } else if (direction == ForgeDirection.EAST) {
            GL11.glRotatef(90F, 0F, 0F, 1F);
        } else if (direction == ForgeDirection.WEST) {
            GL11.glRotatef(-90F, 0F, 0F, 1F);
        }
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
    }

    public void drawCore(TileEntity tileEntity) {
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads(); {
            tessellator.addVertexWithUV(5*pixel, 5*pixel, 5*pixel, 6*pixel, 12*pixel);
            tessellator.addVertexWithUV(5*pixel, 1-5*pixel, 5*pixel, 6*pixel, 6*pixel);
            tessellator.addVertexWithUV(1-5*pixel, 1-5*pixel, 5*pixel, 0*pixel, 6*pixel);
            tessellator.addVertexWithUV(1-5*pixel, 5*pixel, 5*pixel, 0*pixel, 12*pixel);

            tessellator.addVertexWithUV(1-5*pixel, 5*pixel, 5*pixel, 6*pixel, 12*pixel);
            tessellator.addVertexWithUV(1-5*pixel, 1-5*pixel, 5*pixel, 6*pixel, 6*pixel);
            tessellator.addVertexWithUV(1-5*pixel, 1-5*pixel, 1-5*pixel, 0*pixel, 6*pixel);
            tessellator.addVertexWithUV(1-5*pixel, 5*pixel, 1-5*pixel, 0*pixel, 12*pixel);

            tessellator.addVertexWithUV(1-5*pixel, 5*pixel, 1-5*pixel, 6*pixel, 12*pixel);
            tessellator.addVertexWithUV(1-5*pixel, 1-5*pixel, 1-5*pixel, 6*pixel, 6*pixel);
            tessellator.addVertexWithUV(5*pixel, 1-5*pixel, 1-5*pixel, 0*pixel, 6*pixel);
            tessellator.addVertexWithUV(5*pixel, 5*pixel, 1-5*pixel, 0*pixel, 12*pixel);

            tessellator.addVertexWithUV(5*pixel, 5*pixel, 1-5*pixel, 6*pixel, 12*pixel);
            tessellator.addVertexWithUV(5*pixel, 1-5*pixel, 1-5*pixel, 6*pixel, 6*pixel);
            tessellator.addVertexWithUV(5*pixel, 1-5*pixel, 5*pixel, 0*pixel, 6*pixel);
            tessellator.addVertexWithUV(5*pixel, 5*pixel, 5*pixel, 0*pixel, 12*pixel);

            tessellator.addVertexWithUV(5*pixel, 1-5*pixel, 5*pixel, 6*pixel, 12*pixel);
            tessellator.addVertexWithUV(5*pixel, 1-5*pixel, 1-5*pixel, 6*pixel, 6*pixel);
            tessellator.addVertexWithUV(1-5*pixel, 1-5*pixel, 1-5*pixel, 0*pixel, 6*pixel);
            tessellator.addVertexWithUV(1-5*pixel, 1-5*pixel, 5*pixel, 0*pixel, 12*pixel);

            tessellator.addVertexWithUV(1-5*pixel, 5*pixel, 5*pixel, 6*pixel, 12*pixel);
            tessellator.addVertexWithUV(1-5*pixel, 5*pixel, 1-5*pixel, 6*pixel, 6*pixel);
            tessellator.addVertexWithUV(5*pixel, 5*pixel, 1-5*pixel, 0*pixel, 6*pixel);
            tessellator.addVertexWithUV(5*pixel, 5*pixel, 5*pixel, 0*pixel, 12*pixel);

            if (drawInside) {
                tessellator.addVertexWithUV(1-5*pixel, 5*pixel, 6*pixel, 6*pixel, 12*pixel);
                tessellator.addVertexWithUV(1-5*pixel, 1-5*pixel, 6*pixel, 6*pixel, 6*pixel);
                tessellator.addVertexWithUV(5*pixel, 1-5*pixel, 6*pixel, 0*pixel, 6*pixel);
                tessellator.addVertexWithUV(5*pixel, 5*pixel, 6*pixel, 0*pixel, 12*pixel);

                tessellator.addVertexWithUV(1-6*pixel, 5*pixel, 1-5*pixel, 6*pixel, 12*pixel);
                tessellator.addVertexWithUV(1-6*pixel, 1-5*pixel, 1-5*pixel, 6*pixel, 6*pixel);
                tessellator.addVertexWithUV(1-6*pixel, 1-5*pixel, 5*pixel, 0*pixel, 6*pixel);
                tessellator.addVertexWithUV(1-6*pixel, 5*pixel, 5*pixel, 0*pixel, 12*pixel);

                tessellator.addVertexWithUV(5*pixel, 5*pixel, 1-6*pixel, 6*pixel, 12*pixel);
                tessellator.addVertexWithUV(5*pixel, 1-5*pixel, 1-6*pixel, 6*pixel, 6*pixel);
                tessellator.addVertexWithUV(1-5*pixel, 1-5*pixel, 1-6*pixel, 0*pixel, 6*pixel);
                tessellator.addVertexWithUV(1-5*pixel, 5*pixel, 1-6*pixel, 0*pixel, 12*pixel);

                tessellator.addVertexWithUV(6*pixel, 5*pixel, 5*pixel, 6*pixel, 12*pixel);
                tessellator.addVertexWithUV(6*pixel, 1-5*pixel, 5*pixel, 6*pixel, 6*pixel);
                tessellator.addVertexWithUV(6*pixel, 1-5*pixel, 1-5*pixel, 0*pixel, 6*pixel);
                tessellator.addVertexWithUV(6*pixel, 5*pixel, 1-5*pixel, 0*pixel, 12*pixel);

                tessellator.addVertexWithUV(1-5*pixel, 1-6*pixel, 5*pixel, 6*pixel, 12*pixel);
                tessellator.addVertexWithUV(1-5*pixel, 1-6*pixel, 1-5*pixel, 6*pixel, 6*pixel);
                tessellator.addVertexWithUV(5*pixel, 1-6*pixel, 1-5*pixel, 0*pixel, 6*pixel);
                tessellator.addVertexWithUV(5*pixel, 1-6*pixel, 5*pixel, 0*pixel, 12*pixel);

                tessellator.addVertexWithUV(5*pixel, 6*pixel, 5*pixel, 6*pixel, 12*pixel);
                tessellator.addVertexWithUV(5*pixel, 6*pixel, 1-5*pixel, 6*pixel, 6*pixel);
                tessellator.addVertexWithUV(1-5*pixel, 6*pixel, 1-5*pixel, 0*pixel, 6*pixel);
                tessellator.addVertexWithUV(1-5*pixel, 6*pixel, 5*pixel, 0*pixel, 12*pixel);
            }
        }
        tessellator.draw();
    }
}
