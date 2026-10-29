# Task Loadout Planner (RuneLite plugin)

Plans what to bring for your Slayer task or Hunter creature: where to go, what you must bring, what helps, and which of those items you already own and where they're stored.

> Work in progress. The Storage tab works now; the Slayer and Hunter tabs are being built.

## Planned for the first release

- **Slayer**: reads your current task, lists every location it spawns (with quest and level access checks), the items the task requires, recommended gear filtered to what you own, supplies, and loot-storage helpers such as the herb sack or gem bag when the monster drops a lot of herbs or gems.
- **Hunter**: picks up your Hunters' Rumour or a creature you choose, and lists the method's traps and tools (teasing stick, axe, knife and so on), how many traps your level allows, and fur and meat pouches.
- **Storage**: everything you own across your bank, seed vault, tackle box, forestry kit, huntsman's kit, cargo holds and other storage.

This is a planning tool for before a trip. It shows nothing during combat: no attack timers, prayer cues or tile markers.

## Where the data comes from

Monster, drop, location and recommended-equipment data will come from the OSRS Wiki's structured data, downloaded and cached in the plugin's data folder. Data © OSRS Wiki contributors, CC BY-NC-SA 3.0.

## Running it

Requires JDK 11+.

```
./gradlew run          (Windows: gradlew.bat run)
```
