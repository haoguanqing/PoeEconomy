package com.ghao.lib.core.data

import java.lang.IllegalArgumentException

enum class ItemCategory {
    // currency
    Fragment,
    Currency,
    // item
    Oil,
    Artifact,
    Incubator,
    Scarab,
    Fossil,
    Resonator,
    Essence,
    DivinationCard,
    SkillGem,
    BaseType,
    HelmetEnchant,
    UniqueMap,
    Map,
    UniqueJewel,
    UniqueFlask,
    UniqueWeapon,
    UniqueArmour,
    UniqueAccessory,
    Beast,
    Vial;

    companion object {
        fun fromType(type: String): ItemCategory {
            return ItemCategory.values().find { it.name == type }
                ?: throw IllegalArgumentException("Invalid type")
        }
    }
}


