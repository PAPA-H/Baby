package com.babyfood.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name="PARENTS")
public class Parent {
    @Id @GeneratedValue
    @Column(name="PARENT_ID")
    private Long id;
    private String name;
    private String nick;

    @OneToMany(mappedBy = "parent")
    private List<Feed> feed;

    @Getter
    @Setter
    public static class Response{
        private Long parentId;
        private String parentName;
        private String parentNick;

        public Response(Parent parent){
            parentId = parent.getId();
            parentName = parent.getName();
            parentNick = parent.getNick();
        }
    }

}
