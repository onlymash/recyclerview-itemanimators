package im.mash.recyclerview.itemanimators

/**
 * Created by mikepenz on 08.01.16.
 */
class AlphaCrossFadeAnimator : DefaultAnimator<AlphaCrossFadeAnimator>() {

    override fun getAddDelay(remove: Long, move: Long, change: Long): Long {
        return 0
    }

    override fun getRemoveDelay(remove: Long, move: Long, change: Long): Long {
        return remove / 2
    }
}
