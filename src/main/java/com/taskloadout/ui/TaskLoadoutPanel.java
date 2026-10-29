package com.taskloadout.ui;

import com.taskloadout.items.ItemStore;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.PluginPanel;

public class TaskLoadoutPanel extends PluginPanel
{
	private final StorageTab storageTab;

	public TaskLoadoutPanel(ItemManager itemManager, ItemStore store, TaskHost host)
	{
		super(false);
		setLayout(new BorderLayout(0, Theme.GAP));
		setBackground(Theme.BG);
		setBorder(new EmptyBorder(Theme.PANEL_PAD + 2, Theme.PANEL_PAD, Theme.PANEL_PAD, Theme.PANEL_PAD - 2));

		IconCache icons = new IconCache(itemManager);
		storageTab = new StorageTab(store, icons);

		CardLayout cards = new CardLayout();
		JPanel content = new JPanel(cards);
		content.setOpaque(false);
		content.add(new ComingSoonTab("Slayer", "Your slayer task, where to go, required items, gear and loot storage will show here."), "slayer");
		content.add(new ComingSoonTab("Hunter", "Your Hunters' Rumour or chosen creature, with traps, tools and pouches, will show here."), "hunter");
		content.add(storageTab, "storage");

		Kit.Segmented tabs = new Kit.Segmented(true, "Slayer", "Hunter", "Storage");
		tabs.onChange(i -> cards.show(content, i == 0 ? "slayer" : i == 1 ? "hunter" : "storage"));
		JPanel header = new JPanel(new BorderLayout());
		header.setOpaque(false);
		header.setBorder(new EmptyBorder(0, 0, 0, Kit.ThinScrollBarUI.WIDTH));
		header.add(tabs, BorderLayout.CENTER);

		add(header, BorderLayout.NORTH);
		add(content, BorderLayout.CENTER);

		store.addListener(() -> SwingUtilities.invokeLater(this::onItemsChanged));
	}

	public void onItemsChanged()
	{
		storageTab.refresh();
	}

	/**
	 * Levels, quests, account type or settings changed.
	 */
	public void onSettingsChanged()
	{
		storageTab.refresh();
	}
}
