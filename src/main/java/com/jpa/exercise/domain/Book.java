package com.jpa.exercise.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    private Long id;
    private String name;
//    private Long authorId; // id만 name은 없음

    @ManyToOne
    @JoinColumn(name = "author_id") // JPA가 Foreign Key를 걸어wna
    private Author author;
    /* author
    [{"bookId":1,"bookName":"토비의 스프링3","authorName":"김경록"},
    {"bookId":2,"bookName":"스프링부트 핵심가이드","authorName":"장정우"},
    {"bookId":3,"bookName":"말랑말랑 알고리즘","authorName":"이일민"},
    {"bookId":4,"bookName":"한입에 웹 크롤링","authorName":"이일민"},
    {"bookId":5,"bookName":"MySql로 배우는 데이터베이스 개론과 실습","authorName":"박우창"}]
     */

    @OneToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    /* publisher 추가
    [{"bookId":1,"bookName":"토비의 스프링3","authorName":"김경록","publisherName":"에이콘"},
    {"bookId":2,"bookName":"스프링부트 핵심가이드","authorName":"장정우","publisherName":"위키북스"},
    {"bookId":3,"bookName":"말랑말랑 알고리즘","authorName":"이일민","publisherName":"비제이퍼블릭"},
    {"bookId":4,"bookName":"한입에 웹 크롤링","authorName":"이일민","publisherName":"비제이퍼블릭"},
    {"bookId":5,"bookName":"MySql로 배우는 데이터베이스 개론과 실습","authorName":"박우창","publisherName":"한빛아카데미"}]
     */
}
