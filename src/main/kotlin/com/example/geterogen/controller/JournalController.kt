package com.example.geterogen.controller


import com.example.geterogen.model.Journal
import com.example.geterogen.model.Mark
import com.example.geterogen.service.JournalService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/journal")
@CrossOrigin
class JournalController(private val service: JournalService) {

    @GetMapping
    fun index(@RequestParam(required = false) group: String?, @RequestParam(required = false) id: Int?): Iterable<Journal> {
        group?.let {
            return service.findByGroup(group)
        }
        id?.let {
            return service.findByStudentId(id)
        }
        return service.findAll()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int) = service.findById(id)

    @PostMapping()
    fun create(@RequestBody journal: Journal) = service.create(journal)

    @PatchMapping("/{id}")
    fun patchMark(@PathVariable id: Int, @RequestBody mark: Mark) = service.updateMark(mark, id)
}