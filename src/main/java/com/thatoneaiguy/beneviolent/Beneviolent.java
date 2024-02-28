package com.thatoneaiguy.beneviolent;

import com.thatoneaiguy.beneviolent.init.BeneviolentItems;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Beneviolent implements ModInitializer {

	public static final String MODID = "beneviolence";

	public static final Logger LOGGER = LoggerFactory.getLogger("beneviolence");

	@Override
	public void onInitialize(ModContainer mod) {

		LOGGER.info("love could be labeled poison and we'd still drink it anyway");

		BeneviolentItems.register();

	}
}
