package com.mythden.juxtapose;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Juxtapose implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("juxtapose");
	public static final String MOD_ID = "juxtapose";

	@Override
	public void onInitialize() {
		LOGGER.info("Hello from Juxtapose!");
		JuxtaposeRegistry.register();
	}
}
