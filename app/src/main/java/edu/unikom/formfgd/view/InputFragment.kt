package edu.unikom.formfgd.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import edu.unikom.formfgd.R
import edu.unikom.formfgd.databinding.FragmentInputBinding
import edu.unikom.formfgd.model.AttendanceModel
import edu.unikom.formfgd.viewmodel.AttendanceViewModel

class InputFragment : Fragment() {

    private lateinit var binding: FragmentInputBinding

    private val viewModel: AttendanceViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentInputBinding.inflate(inflater, container, false)

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.kategori_peserta,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spkategori.adapter = adapter
        }
        binding.btnSubmit.setOnClickListener {
            val model = AttendanceModel(
                nama = binding.edtNama.text.toString(),
                telepon = binding.edtTelepon.text.toString(),
                email = binding.edtEmail.text.toString(),
                gender = if (binding.radLakilaki.isChecked) "Laki-Laki" else "Perempuan",
                skillset = listOfNotNull(
                    if (binding.chkAlgo.isChecked) "Algoritma" else null,
                    if (binding.chkProblemSolving.isChecked) "Problem Solving" else null,
                    if (binding.chkProgramming.isChecked) "Programming" else null,
                    if (binding.chkDesignthinking.isChecked) "Design Thinking" else null,
                    if (binding.chkCriticalthinking.isChecked) "Critical Thinking" else null
                ),
                kategori = binding.spkategori.selectedItem.toString()
            )
            viewModel.setAttendanceData(model)
            parentFragmentManager.beginTransaction()
                .replace(R.id.Fragment_container, OutputFragment())
                .addToBackStack(null)
                .commit()
        }
        return binding.root

    }
}