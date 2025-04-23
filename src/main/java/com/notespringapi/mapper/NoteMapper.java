package com.notespringapi.mapper;

import com.notespringapi.dto.NoteDto;
import com.notespringapi.dto.NotePatchDto;
import com.notespringapi.model.Note;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface NoteMapper {

    NoteDto fromEntity(Note note);
    Note toEntity(NoteDto noteDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateNoteFromDto(NotePatchDto notePatchDto, @MappingTarget Note note);
}
