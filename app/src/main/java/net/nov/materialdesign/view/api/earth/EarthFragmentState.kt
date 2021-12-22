package net.nov.materialdesign.view.api.earth

import net.nov.materialdesign.repository.PictureOfTheDayResponseData

sealed class EarthFragmentState {
    data class Success(val pictureOfTheDayResponseData: PictureOfTheDayResponseData) :
        EarthFragmentState()

    data class Loading(val progress: Int?) : EarthFragmentState()
    data class Error(val error: Throwable) : EarthFragmentState()
}