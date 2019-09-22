/*
 * Copyright 2019 Lukoh Nam, goForer
 *    
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, 
 * or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU General Public License for more details. 
 * You should have received a copy of the GNU General Public License along with this program.  
 * If not, see <http://www.gnu.org/licenses/>.
 */

@file:Suppress("UNCHECKED_CAST", "DEPRECATION")

package com.goforer.grabph.presentation.common.view.drawer.item

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView
import android.util.Pair
import com.goforer.grabph.R
import com.mikepenz.iconics.typeface.IIcon
import com.mikepenz.materialdrawer.holder.ColorHolder
import com.mikepenz.materialdrawer.holder.ImageHolder
import com.mikepenz.materialdrawer.holder.StringHolder
import com.mikepenz.materialdrawer.model.AbstractDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.Iconable
import com.mikepenz.materialdrawer.model.interfaces.Nameable
import com.mikepenz.materialdrawer.model.interfaces.Tagable
import com.mikepenz.materialdrawer.model.interfaces.Typefaceable
import com.mikepenz.materialdrawer.util.DrawerUIUtils

abstract class BaseDrawerItem<T, VH : androidx.recyclerview.widget.RecyclerView.ViewHolder> : AbstractDrawerItem<T, VH>(), Nameable<T>, Iconable<T>, Tagable<T>, Typefaceable<T> {
    private lateinit var icon: ImageHolder
    private lateinit var selectedIcon: ImageHolder
    private lateinit var name: StringHolder

    private var isIconTinted = false

    private lateinit var selectedColor: ColorHolder
    private lateinit var textColor: ColorHolder

    private lateinit var selectedTextColor: ColorHolder
    private lateinit var disabledTextColor: ColorHolder

    private lateinit var iconColor: ColorHolder
    private lateinit var selectedIconColor: ColorHolder

    private lateinit var disabledIconColor: ColorHolder

    private var typeface: Typeface? = null

    private var colorStateList: android.util.Pair<Int, ColorStateList>? = null

    private var level = 1

    override fun withIcon(icon: ImageHolder): T {
        this.icon = icon
        return this as T
    }

    override fun withIcon(icon: Drawable): T {
        this.icon = ImageHolder(icon)
        return this as T
    }

    fun withIcon(@DrawableRes iconRes: Int): T {
        this.icon = ImageHolder(iconRes)
        return this as T
    }

    fun withSelectedIcon(selectedIcon: Drawable): T {
        this.selectedIcon = ImageHolder(selectedIcon)
        return this as T
    }

    fun withSelectedIcon(@DrawableRes selectedIconRes: Int): T {
        this.selectedIcon = ImageHolder(selectedIconRes)
        return this as T
    }

    @SuppressLint("ObsoleteSdkInt")
    override fun withIcon(iicon: IIcon): T {
        this.icon = ImageHolder(iicon)
        //if we are on api 21 or higher we use the IconicsDrawable for selection too and color it with the correct color
        //else we use just the one drawable and enable tinting on press
        if (Build.VERSION.SDK_INT >= 21) {
            this.selectedIcon = ImageHolder(iicon)
        } else {
            this.withIconTintingEnabled(true)
        }

        return this as T
    }

    override fun withName(name: StringHolder): T {
        this.name = name
        return this as T
    }

    override fun withName(name: String): T {
        this.name = StringHolder(name)
        return this as T
    }

    override fun withName(@StringRes nameRes: Int): T {
        this.name = StringHolder(nameRes)
        return this as T
    }

    fun withSelectedColor(@ColorInt selectedColor: Int): T {
        this.selectedColor = ColorHolder.fromColor(selectedColor)
        return this as T
    }

    fun withSelectedColorRes(@ColorRes selectedColorRes: Int): T {
        this.selectedColor = ColorHolder.fromColorRes(selectedColorRes)
        return this as T
    }

    fun withTextColor(@ColorInt textColor: Int): T {
        this.textColor = ColorHolder.fromColor(textColor)
        return this as T
    }

    fun withTextColorRes(@ColorRes textColorRes: Int): T {
        this.textColor = ColorHolder.fromColorRes(textColorRes)
        return this as T
    }

    fun withSelectedTextColor(@ColorInt selectedTextColor: Int): T {
        this.selectedTextColor = ColorHolder.fromColor(selectedTextColor)
        return this as T
    }

    fun withSelectedTextColorRes(@ColorRes selectedColorRes: Int): T {
        this.selectedTextColor = ColorHolder.fromColorRes(selectedColorRes)
        return this as T
    }

    fun withDisabledTextColor(@ColorInt disabledTextColor: Int): T {
        this.disabledTextColor = ColorHolder.fromColor(disabledTextColor)
        return this as T
    }

    fun withDisabledTextColorRes(@ColorRes disabledTextColorRes: Int): T {
        this.disabledTextColor = ColorHolder.fromColorRes(disabledTextColorRes)
        return this as T
    }

    fun withIconColor(@ColorInt iconColor: Int): T {
        this.iconColor = ColorHolder.fromColor(iconColor)
        return this as T
    }

    fun withIconColorRes(@ColorRes iconColorRes: Int): T {
        this.iconColor = ColorHolder.fromColorRes(iconColorRes)
        return this as T
    }

    fun withSelectedIconColor(@ColorInt selectedIconColor: Int): T {
        this.selectedIconColor = ColorHolder.fromColor(selectedIconColor)
        return this as T
    }

    fun withSelectedIconColorRes(@ColorRes selectedColorRes: Int): T {
        this.selectedIconColor = ColorHolder.fromColorRes(selectedColorRes)
        return this as T
    }

    fun withDisabledIconColor(@ColorInt disabledIconColor: Int): T {
        this.disabledIconColor = ColorHolder.fromColor(disabledIconColor)
        return this as T
    }

    fun withDisabledIconColorRes(@ColorRes disabledIconColorRes: Int): T {
        this.disabledIconColor = ColorHolder.fromColorRes(disabledIconColorRes)
        return this as T
    }

    /**
     * will tint the icon with the default (or set) colors
     * (default and selected state)
     *
     * @param iconTintingEnabled
     * @return
     */
    fun withIconTintingEnabled(iconTintingEnabled: Boolean): T {
        this.isIconTinted = iconTintingEnabled
        return this as T
    }

    @Deprecated("")
    fun withIconTinted(iconTinted: Boolean): T {
        this.isIconTinted = iconTinted
        return this as T
    }

    /**
     * for backwards compatibility - withIconTinted..
     *
     * @param iconTinted
     * @return
     */
    @Deprecated("", ReplaceWith("withIconTintingEnabled(iconTinted)"))
    fun withTintSelectedIcon(iconTinted: Boolean): T {
        return withIconTintingEnabled(iconTinted)
    }

    override fun withTypeface(typeface: Typeface): T {
        this.typeface = typeface
        return this as T
    }

    fun withLevel(level: Int): T {
        this.level = level
        return this as T
    }

    override fun getIcon(): ImageHolder {
        return icon
    }

    override fun getName(): StringHolder {
        return name
    }

    override fun getTypeface(): Typeface? {
        return typeface
    }

    /**
     * helper method to decide for the correct color
     *
     * @param ctx
     * @return
     */
    fun getSelectedColor(ctx: Context): Int {
        return ColorHolder.color(selectedColor, ctx, R.attr.material_drawer_selected, R.color.material_drawer_selected)
    }

    /**
     * helper method to decide for the correct color
     *
     * @param ctx
     * @return
     */
    protected fun getColor(ctx: Context): Int {
        return if (isEnabled) {
            ColorHolder.color(textColor, ctx, R.attr.material_drawer_primary_text, R.color.material_drawer_primary_text)
        } else {
            ColorHolder.color(disabledTextColor, ctx, R.attr.material_drawer_hint_text, R.color.material_drawer_hint_text)
        }
    }

    /**
     * helper method to decide for the correct color
     *
     * @param ctx
     * @return
     */
    protected fun getSelectedTextColor(ctx: Context): Int {
        return ColorHolder.color(selectedTextColor, ctx, R.attr.material_drawer_selected_text, R.color.material_drawer_selected_text)
    }

    /**
     * helper method to decide for the correct color
     *
     * @param ctx
     * @return
     */
    fun getIconColor(ctx: Context): Int {
        val iconColor: Int = if (this.isEnabled) {
            ColorHolder.color(this.iconColor, ctx, R.attr.material_drawer_primary_icon, R.color.material_drawer_primary_icon)
        } else {
            ColorHolder.color(disabledIconColor, ctx, R.attr.material_drawer_hint_icon, R.color.material_drawer_hint_icon)
        }
        return iconColor
    }

    /**
     * helper method to decide for the correct color
     *
     * @param ctx
     * @return
     */
    fun getSelectedIconColor(ctx: Context): Int {
        return ColorHolder.color(selectedIconColor, ctx, R.attr.material_drawer_selected_text, R.color.material_drawer_selected_text)
    }

    /**
     * helper to get the ColorStateList for the text and remembering it so we do not have to recreate it all the time
     *
     * @param color
     * @param selectedTextColor
     * @return
     */
    fun getTextColorStateList(@ColorInt color: Int, @ColorInt selectedTextColor: Int): ColorStateList {
        if (colorStateList == null || color + selectedTextColor != colorStateList!!.first) {
            colorStateList = Pair(color + selectedTextColor, DrawerUIUtils.getTextColorStateList(color, selectedTextColor))
        }

        return colorStateList!!.second
    }
}