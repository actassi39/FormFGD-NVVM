package edu.unikom.formfgd.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import edu.unikom.formfgd.R
import edu.unikom.formfgd.databinding.FragmentOutputBinding
import edu.unikom.formfgd.viewmodel.AttendanceViewModel

class OutputFragment : Fragment() {

    private lateinit var binding: FragmentOutputBinding
    private val viewModel: AttendanceViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOutputBinding.inflate(inflater, container, false)
        viewModel.attendanceData.observe(viewLifecycleOwner) { model ->
            binding.txtNamaResult.text = model.nama
            binding.txtEmailResult.text = model.telepon
            binding.txtGenderResult.text = model.gender
            binding.txtKategoriResult.text = model.kategori
            binding.txtSkillsetResult.text = model.skillset.joinToString(", ")
            binding.txtTeleponResult.text = model.email

        }
        return binding.root

    }
}