package gregtech.api.capability.impl;

import java.util.*;

public class MultiblockRecipeLogicWrapper {

	final MultiblockRecipeLogic logic;

	public MultiblockRecipeLogicWrapper(MultiblockRecipeLogic logic) {
		Objects.requireNonNull(logic);
		this.logic = logic;
	}

	public void invertWasActiveAndNeedsUpdate() {
		logic.wasActiveAndNeedsUpdate = !logic.wasActiveAndNeedsUpdate;
	}
}
