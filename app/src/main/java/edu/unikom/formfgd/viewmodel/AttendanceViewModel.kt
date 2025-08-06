package edu.unikom.formfgd.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.unikom.formfgd.model.AttendanceModel

class AttendanceViewModel: ViewModel() {

    private val _attendanceData = MutableLiveData<AttendanceModel>()
    val attendanceData: LiveData<AttendanceModel> get() = _attendanceData

    fun setAttendanceData(model: AttendanceModel){
        _attendanceData.value = model
    }
}