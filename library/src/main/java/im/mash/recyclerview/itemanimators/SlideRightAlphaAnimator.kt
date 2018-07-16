package im.mash.recyclerview.itemanimators

import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorCompat
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by mikepenz on 08.01.16.
 */
class SlideRightAlphaAnimator : DefaultAnimator<SlideRightAlphaAnimator>() {
    override fun addAnimationPrepare(holder: RecyclerView.ViewHolder) {
        holder.itemView.alpha = 0f
        holder.itemView.translationX = (-holder.itemView.width).toFloat()
    }

    override fun addAnimation(holder: RecyclerView.ViewHolder): ViewPropertyAnimatorCompat {
        return ViewCompat.animate(holder.itemView).translationX(0f).alpha(1f).setDuration(moveDuration).setInterpolator(interpolator)
    }

    override fun addAnimationCleanup(holder: RecyclerView.ViewHolder) {
        holder.itemView.alpha = 1f
        holder.itemView.translationX = 0f
    }

    override fun getAddDelay(remove: Long, move: Long, change: Long): Long {
        return 0
    }

    override fun getRemoveDelay(remove: Long, move: Long, change: Long): Long {
        return 0
    }

    override fun removeAnimation(holder: RecyclerView.ViewHolder): ViewPropertyAnimatorCompat {
        val animation = ViewCompat.animate(holder.itemView)
        return animation.setDuration(removeDuration).alpha(0f).translationX((-holder.itemView.width).toFloat()).setInterpolator(interpolator)
    }

    override fun removeAnimationCleanup(holder: RecyclerView.ViewHolder) {
        holder.itemView.alpha = 1f
        holder.itemView.translationX = 0f
    }
}