package com.lesson.spring.service;

import com.lesson.spring.api.professor.request.CreateProfessorRequest;
import com.lesson.spring.api.professor.request.UpdateProfessorRequest;
import com.lesson.spring.api.professor.response.ProfessorResponse;
import com.lesson.spring.entity.Professor;
import com.lesson.spring.exception.NotFoundProfessorException;
import com.lesson.spring.repository.ProfessorRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    @Transactional
    public void save(CreateProfessorRequest request) {

        Professor professor = Professor.builder()
                .name(request.getName())
                .build();

        professorRepository.save(professor);
    }

    public List<ProfessorResponse> findAll() {

        List<Professor> professors = professorRepository.findAll();

//        return professors.stream().map((professor) -> ProfessorResponse.builder()
//                .id(professor.getId())
//                .name(professor.getName())
//                .build()
//        ).toList();

        // 생성자
//        return professors.stream()
//                .map(p -> new ProfessorResponse(p.getId(), p.getName()))
//                .collect(Collectors.toList());

        return professors.stream()
                .map(ProfessorResponse::from)
                .collect(Collectors.toList());
    }

    public List<ProfessorResponse> findByName(String name) {

        List<Professor> findProfessorByName = professorRepository.findByName(name);

        if (findProfessorByName.isEmpty()) {
            throw new NotFoundProfessorException();
        }
        return findProfessorByName.stream().map(
                professor -> ProfessorResponse.from(professor)
        ).toList();
    }

    @Transactional
    public void update(Long professorId, UpdateProfessorRequest request) {
        Professor findProfessor = professorRepository.findById(professorId);

        if (findProfessor == null) {
            throw new NotFoundProfessorException();
        }

        findProfessor.changeName(request.getName());
//        professorRepository.save(findProfessor);
    }


    @Transactional
    public void delete(Long professorId) {
        Professor findProfessor = professorRepository.findById(professorId);

        if (findProfessor == null) {
            throw new NotFoundProfessorException();
        }

        professorRepository.delete(findProfessor.getId());
    }

}
