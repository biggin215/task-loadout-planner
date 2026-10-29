package com.taskloadout.ui;

import java.awt.Component;
import java.awt.Dimension;
import java.util.concurrent.TimeUnit;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * Shared layout helpers for the sidebar.
 */
final class Layout
{
	/** Width used to size wrapped text before the panel's first layout. */
	static final int WIDTH_HINT = Theme.SIDEBAR_WIDTH - Theme.PANEL_PAD * 2 - Kit.ThinScrollBarUI.WIDTH;

	private Layout()
	{
	}

	static JPanel column()
	{
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setOpaque(false);
		return p;
	}

	/**
	 * Left-aligned and allowed to stretch to the full width, keeping its own height.
	 */
	static <T extends JComponent> T stretch(T c)
	{
		c.setAlignmentX(Component.LEFT_ALIGNMENT);
		if (!(c instanceof Kit.SectionHeader) && !(c instanceof Kit.SearchField) && !(c instanceof Kit.Dropdown))
		{
			c.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
		}
		return c;
	}

	static String ago(long time)
	{
		if (time <= 0)
		{
			return "never";
		}
		long diff = Math.max(0, System.currentTimeMillis() - time);
		if (diff < TimeUnit.MINUTES.toMillis(1))
		{
			return "just now";
		}
		if (diff < TimeUnit.HOURS.toMillis(1))
		{
			return TimeUnit.MILLISECONDS.toMinutes(diff) + "m ago";
		}
		if (diff < TimeUnit.DAYS.toMillis(1))
		{
			return TimeUnit.MILLISECONDS.toHours(diff) + "h ago";
		}
		return TimeUnit.MILLISECONDS.toDays(diff) + "d ago";
	}
}
