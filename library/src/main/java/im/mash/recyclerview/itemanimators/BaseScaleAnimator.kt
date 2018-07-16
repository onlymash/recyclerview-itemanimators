package im.mash.recyclerview.itemanimators

import androidx.recyclerview.widget.RecyclerView

/**
 * Created by mikepenz on 08.01.16.
 */
abstract class BaseScaleAnimator<T> : BaseItemAnimator<T>() {
    override fun changeAnimation(oldHolder: RecyclerView.ViewHolder, newHolder: RecyclerView.ViewHolder?, fromX: Int, fromY: Int, toX: Int, toY: Int) {
        val prevTranslationX = oldHolder.itemView.translationX
        val prevTranslationY = oldHolder.itemView.translationY
        val prevValue = changeAnimationPrepare1(oldHolder)
        resetAnimation(oldHolder)
        val deltaX = (toX.toFloat() - fromX.toFloat() - prevTranslationX).toInt()
        val deltaY = (toY.toFloat() - fromY.toFloat() - prevTranslationY).toInt()
        // recover prev translation state after ending animation
        oldHolder.itemView.translationX = prevTranslationX
        oldHolder.itemView.translationY = prevTranslationY

        changeAnimationPrepare2(oldHolder, prevValue)
        if (newHolder != null) {
            // carry over translation values
            resetAnimation(newHolder)
            newHolder.itemView.translationX = (-deltaX).toFloat()
            newHolder.itemView.translationY = (-deltaY).toFloat()
            changeAnimationPrepare3(newHolder)
        }
    }

    /**
     * @param holder
     * @return the default value for the animatd attribute
     */
    abstract fun changeAnimationPrepare1(holder: RecyclerView.ViewHolder): Float

    /**
     * animates the view to the previous default value
     *
     * @param holder
     * @param prevValue the previous value
     */
    abstract fun changeAnimationPrepare2(holder: RecyclerView.ViewHolder, prevValue: Float)

    /**
     * resets the value
     *
     * @param holder
     */
    abstract fun changeAnimationPrepare3(holder: RecyclerView.ViewHolder)
}
