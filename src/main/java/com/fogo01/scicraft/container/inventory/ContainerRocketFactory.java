package com.fogo01.scicraft.container.inventory;

import com.fogo01.scicraft.container.inventory.slot.SlotRocketFactory;
import com.fogo01.scicraft.tileentity.TileEntityRocketFactory;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerRocketFactory extends Container {
    private TileEntityRocketFactory tileEntityRocketFactory;

    private int lastNoseCone;
    private int lastFuselage;
    private int lastEngine;
    private int lastFin;
    private int lastBooster;

    public ContainerRocketFactory(InventoryPlayer inventoryPlayer, TileEntityRocketFactory tileEntityRocketFactory) {
        this.tileEntityRocketFactory = tileEntityRocketFactory;

        this.addSlotToContainer(new Slot(tileEntityRocketFactory, 0, 33, 14));
        this.addSlotToContainer(new Slot(tileEntityRocketFactory, 1, 33, 33));
        this.addSlotToContainer(new Slot(tileEntityRocketFactory, 2, 33, 52));
        this.addSlotToContainer(new Slot(tileEntityRocketFactory, 3, 52, 24));
        this.addSlotToContainer(new Slot(tileEntityRocketFactory, 4, 52, 44));

        this.addSlotToContainer(new SlotRocketFactory(inventoryPlayer.player, tileEntityRocketFactory, 5, 116, 35));

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tileEntityRocketFactory.isUseableByPlayer(player);
    }

    @Override
    public void addCraftingToCrafters(ICrafting iCrafting) {
        super.addCraftingToCrafters(iCrafting);
        iCrafting.sendProgressBarUpdate(this, 0, this.tileEntityRocketFactory.noseCone);
        iCrafting.sendProgressBarUpdate(this, 1, this.tileEntityRocketFactory.fuselage);
        iCrafting.sendProgressBarUpdate(this, 2, this.tileEntityRocketFactory.engine);
        iCrafting.sendProgressBarUpdate(this, 3, this.tileEntityRocketFactory.fin);
        iCrafting.sendProgressBarUpdate(this, 4, this.tileEntityRocketFactory.booster);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i) {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.lastNoseCone != this.tileEntityRocketFactory.noseCone) {
                icrafting.sendProgressBarUpdate(this, 0, this.tileEntityRocketFactory.noseCone);
            }
            if (this.lastFuselage != this.tileEntityRocketFactory.fuselage) {
                icrafting.sendProgressBarUpdate(this, 1, this.tileEntityRocketFactory.fuselage);
            }
            if (this.lastEngine != this.tileEntityRocketFactory.engine) {
                icrafting.sendProgressBarUpdate(this, 2, this.tileEntityRocketFactory.engine);
            }
            if (this.lastFin != this.tileEntityRocketFactory.fin) {
                icrafting.sendProgressBarUpdate(this, 3, this.tileEntityRocketFactory.fin);
            }
            if (this.lastBooster != this.tileEntityRocketFactory.booster) {
                icrafting.sendProgressBarUpdate(this, 4, this.tileEntityRocketFactory.booster);
            }

            this.lastNoseCone = this.tileEntityRocketFactory.noseCone;
            this.lastFuselage = this.tileEntityRocketFactory.fuselage;
            this.lastEngine = this.tileEntityRocketFactory.engine;
            this.lastFin = this.tileEntityRocketFactory.fin;
            this.lastBooster = this.tileEntityRocketFactory.booster;
        }
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int p_75137_1_, int p_75137_2_) {
        if (p_75137_1_ == 0) {
            this.tileEntityRocketFactory.noseCone = p_75137_2_;
        }
        if (p_75137_1_ == 1) {
            this.tileEntityRocketFactory.fuselage = p_75137_2_;
        }
        if (p_75137_1_ == 2) {
            this.tileEntityRocketFactory.engine = p_75137_2_;
        }
        if (p_75137_1_ == 3) {
            this.tileEntityRocketFactory.fin = p_75137_2_;
        }
        if (p_75137_1_ == 4) {
            this.tileEntityRocketFactory.booster = p_75137_2_;
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int i) {
        return null;
    }
}
