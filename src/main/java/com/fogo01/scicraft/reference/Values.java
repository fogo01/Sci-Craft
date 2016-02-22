package com.fogo01.scicraft.reference;

public class Values {
    public static final String ENERGY_GAIN = "W";
    public static final String ENERGY_STORAGE = "J";

    public static final class Machines {
        public static final class SolarPanel {
            public static final int ENERGY_STORAGE = 32000;
            public static final int TRANSFER_RATE = 1600;
            public static final int ENERGY_PRODUCTION = 80;
        }

        public static final class BatteryCell {
            public static final int ENERGY_STORAGE = 1000000;
            public static final int TRANSFER_RATE = 1600;
        }

        public static final class PoweredFurnace {
            public static final int ENERGY_STORAGE = 32000;
            public static final int TRANSFER_RATE = 1600;
            public static final int ENERGY_USE = 10;
            public static final int COOK_SPEED = 20;
        }

        public static final class Crusher {
            public static final int ENERGY_STORAGE = 32000;
            public static final int TRANSFER_RATE = 1600;
            public static final int ENERGY_USE = 10;
            public static final int CRUSH_SPEED = 20;
        }

        public static final class AlloySmelter {
            public static final int ENERGY_STORAGE = 32000;
            public static final int TRANSFER_RATE = 1600;
            public static final int ENERGY_USE = 80;
            public static final int COOK_SPEED = 200;
        }
    }

    public static final class Batteries {
        public static final int SMALL_ENERGY_STORAGE = 32000;
        public static final int MEDIUM_BATTERY_STORAGE = 100000;
    }
}
