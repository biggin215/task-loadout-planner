# OSRS Wiki data formats

Samples pulled from the wiki's bucket API (`https://oldschool.runescape.wiki/api.php?action=bucket&format=json&query=...`) on 2026-10-28.
Responses are `{"bucketQuery": "...", "bucket": [rows]}`.

## General rules

- A true yes/no field comes back as `""`; a false one is left out of the row entirely.
- Repeated fields (assigned_by, slayer_category, coordinates) come back as JSON arrays.
- Pages with several infobox versions return one row per version, often identical. Deduplicate.
- Text fields can hold wikitext: `[[Page]]`, `[[Page|Label]]`, `[[Dwarven Mine]]s`. Use the link target for lookups and the cleaned text for display.

## infobox_monster

```
page_name: "Gargoyle"
name: "Gargoyle"
combat_level: 111
slayer_level: 75
slayer_category: ["Gargoyles"]
assigned_by: ["vannaka","chaeldar","konar","nieve","duradel","Mortimer"]   (mixed case)
is_members_only: ""                                                        (true)
```

## dropsline

One row per drop. `drop_json` is a JSON string:

```
{"Dropped item":"Granite maul","Dropped from":"Gargoyle","Rarity":"1/256","Approx":false,
 "Drop Quantity":"1","Quantity Low":1,"Quantity High":1,"Drop level":"111","Drop type":"combat",
 "Drop Value":30000,"Rolls":1,"Alt Rarity":"","Name Notes":"","Rarity Notes":"","League region":"morytania"}
```

Rarity is a fraction string ("4/128"); other forms ("Always", "Rare") need handling.

## locline

One row per location block on a page, with all spawn points in that area:

```
page_name: "Gargoyle"
coordinates: ["x:3432,y:3540","x:3435,y:3548", ...]
plane: 2
mapid: 0          (surface; underground areas use other ids, e.g. 14 with y around 9940)
members: ""
```

NPCs that stand in one spot (most shopkeepers, e.g. Zaff) have no locline rows.

## recommended_equipment

Keyed by the strategy page, not the monster page ("Sorceress's Garden", "Pay-to-play Prayer training").
One row per setup/style. `json`:

```
{"Recommended Equipment": {
   "head": ["<span class=\"plink-template\">[[File:Serpentine helm.png|link=Serpentine helm]]</span>[[Serpentine helm|Serpentine helm]]", ...],
   "weapon": ["... [[Staff of the Dead|Staff of the Dead]] / ... [[Staff of Light|Staff of Light]]", ...],
   ...},
 "style": "High Magic defence"}
```

- Slots: head, neck, cape, body, legs, hands, feet, ring, weapon, shield, ammo.
- Each slot lists options best first; " / " separates equal alternatives within one option.
- Item names = link targets that aren't `File:` links. Strip `UNIQ--ref` markers.
- Some links point to groups rather than items ("God capes", "Cape of Accomplishment", "God blessing").

## infobox_shop

```
page_name: "Varrock Swordshop"
location: "[[Varrock]]"
owner: "[[Shop keeper (Varrock Swordshop)|Shop keeper]]"
is_members_only: (absent = false)
```
