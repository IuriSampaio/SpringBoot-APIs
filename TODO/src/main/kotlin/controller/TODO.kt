package TODO.controller

import TODO.model.ITODO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/notes")
class TODO {

    private val TODOS : Array<ITODO> = arrayOf(
        ITODO(1,"nota 1","fazer tal coisa","dia 1", "dia 10"),
    )

    @GetMapping("")
    fun index(): Array<ITODO>{
        return TODOS
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    fun store( @RequestBody t:ITODO ):ITODO{
        TODOS[TODOS.size] = t

        t.id = TODOS.last().id?.plus(1)

        return TODOS[TODOS.size-1]
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun update( @RequestParam id:Int ){}

    @DeleteMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun delete(){}

}