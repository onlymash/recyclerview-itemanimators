package im.mash.recyclerview.itemanimators

import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorCompat
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by mikepenz on 08.01.16.
 * Base for this animator thanks to @gabrielemariotti - https://github.com/gabrielemariotti/RecyclerViewItemAnimators
 */
class SlideInOutLeftAnimator(private val mRecyclerView: RecyclerView) : DefaultAnimator<SlideInOutLeftAnimator>() {

    private var mDeltaX: Float = 0f

    override fun addAnimationPrepare(holder: RecyclerView.ViewHolder) {
        retrieveItemPosition(holder)
        holder.itemView.translationX = -mDeltaX
        holder.itemView.translationZ = 100f
    }

    override fun addAnimation(holder: RecyclerView.ViewHolder): ViewPropertyAnimatorCompat {
        val view = holder.itemView
        return ViewCompat.animate(view).translationX(0f).alpha(1f).setDuration(addDuration)
    }

    override fun addAnimationCleanup(holder: RecyclerView.ViewHolder) {
        holder.itemView.alpha = 1f
        holder.itemView.translationX = 0f
        holder.itemView.translationZ = 1f
    }

    override fun removeAnimation(holder: RecyclerView.ViewHolder): ViewPropertyAnimatorCompat {
        ViewCompat.setTranslationZ(holder.itemView, 100f)
        val animation = ViewCompat.animate(holder.itemView)
        return animation.setDuration(removeDuration).alpha(0f).translationX(-mDeltaX)
    }

    override fun removeAnimationCleanup(holder: RecyclerView.ViewHolder) {
        holder.itemView.alpha = 1f
        holder.itemView.translationX = 0f
        holder.itemView.translationZ = 1f
    }


    private fun retrieveItemPosition(holder: RecyclerView.ViewHolder) {
        mDeltaX = (mRecyclerView.width - mRecyclerView.layoutManager!!.getDecoratedLeft(holder.itemView)).toFloat()
    }

    override fun getAddDelay(remove: Long, move: Long, change: Long): Long {
        return 0
    }

    override fun getRemoveDelay(remove: Long, move: Long, change: Long): Long {
        return remove / 2
    }

}
