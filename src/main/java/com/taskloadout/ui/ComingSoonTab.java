package com.taskloadout.ui;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Placeholder for a tab that isn't built yet.
 */
class ComingSoonTab extends JPanel
{
	ComingSoonTab(String title, String text)
	{
		super(new BorderLayout());
		setOpaque(false);
		Kit.Card card = new Kit.Card(new BorderLayout()).fill(Theme.CARD).edge(Theme.CARD_BORDER);
		card.setBorder(new EmptyBorder(14, 12, 14, 12));
		card.add(new Kit.TextBlock(Layout.WIDTH_HINT - 24).lines(
			new Kit.Line(title, Theme.bold(), Theme.TEXT),
			new Kit.Line(text, Theme.small(), Theme.MUTED, 4)), BorderLayout.CENTER);
		JPanel top = new JPanel(new BorderLayout());
		top.setOpaque(false);
		top.setBorder(new EmptyBorder(0, 0, 0, Kit.ThinScrollBarUI.WIDTH));
		top.add(card, BorderLayout.NORTH);
		add(top, BorderLayout.NORTH);
	}
}
