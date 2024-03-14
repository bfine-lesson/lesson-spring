package com.lesson.spring.api.professor;

import com.lesson.spring.api.professor.request.CreateProfessorRequest;
import com.lesson.spring.api.professor.request.UpdateProfessorRequest;
import com.lesson.spring.api.professor.response.CreateProfessorResponse;
import com.lesson.spring.api.professor.response.ProfessorResponse;
import com.lesson.spring.api.professor.response.UpdateProfessorResponse;
import com.lesson.spring.service.ProfessorService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/professors")
public class ProfessorApi {

    private final ProfessorService professorService;

    //1. 교수 가입
    @PostMapping
    public CreateProfessorResponse save(@RequestBody CreateProfessorRequest request) {
        professorService.save(request);
        return new CreateProfessorResponse(request.getName());
    }

    //2. 교수 전체 조회
    @GetMapping
    public List<ProfessorResponse> findAll() {
        return professorService.findAll();
    }

    //3. 교수 이름으로 조회
    @GetMapping("/search")
    public List<ProfessorResponse> findByName(@RequestParam String name) {
        return professorService.findByName(name);
    }

    //4. 교수 정보 수정
    @PutMapping("/{professorId}")
    public UpdateProfessorResponse updateProfessor(
            @PathVariable Long professorId,
            @RequestBody UpdateProfessorRequest request) {

        professorService.update(professorId, request);

        return new UpdateProfessorResponse(request.getName());
    }

    //5. 교수 은퇴
    @DeleteMapping("/{professorId}")
    public void deleteProfessor(@PathVariable Long professorId) {
        professorService.delete(professorId);
    }


}
