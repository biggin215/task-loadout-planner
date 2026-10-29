package com.taskloadout.ui;

import java.util.List;

/**
 * What the panel needs from the plugin. All methods are safe to call from the Swing thread.
 */
public interface TaskHost
{
	/** Real level, or -1 when not known yet. */
	int realLevel(String skill);

	/** XP, or -1 when not known yet. */
	long skillXp(String skill);

	/** null when not logged in. */
	Boolean membersWorld();

	boolean ironman();

	/** Quests named in the text that the player hasn't done; partial completion counts where the text says so. */
	List<String> unmetQuests(String requirementText);

	/** null when not known yet; a lookup is started in the background. */
	Boolean stackable(String itemName);

	/** {x, y, plane}, or null when not logged in. */
	int[] playerLocation();
}
