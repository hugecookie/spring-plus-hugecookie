## 4️⃣ 필수 기능

<aside>
✨ **아래 기능은 필수로 개발해주세요!**

</aside>

## Level. 1

### **1. 코드 개선 퀴즈 - @Transactional의 이해**

- 할 일 저장 기능을 구현한 API(`/todos`)를 호출할 때, 아래와 같은 에러가 발생하고 있어요.

    - 에러 로그 원문 보기

      jakarta.servlet.ServletException: Request processing failed: org.springframework.orm.jpa.JpaSystemException: could not execute statement [Connection is read-only. Queries leading to data modification are not allowed] [insert into todos (contents,created_at,modified_at,title,user_id,weather) values (?,?,?,?,?,?)]

- 에러가 발생하지 않고 정상적으로 할 일을 저장 할 수 있도록 코드를 수정해주세요.

### **2. 코드 추가 퀴즈 - JWT의 이해**

<aside>
🚨 기획자의 긴급 요청이 왔어요!
아래의 요구사항에 맞춰 기획 요건에 대응할 수 있는 코드를 작성해주세요.

</aside>

- User의 정보에 nickname이 필요해졌어요.
    - User 테이블에 nickname 컬럼을 추가해주세요.
    - nickname은 중복 가능합니다.
- 프론트엔드 개발자가 JWT에서 유저의 닉네임을 꺼내 화면에 보여주길 원하고 있어요.

### **3. 코드 개선 퀴즈 -  JPA의 이해**

<aside>
🚨 기획자의 긴급 요청이 왔어요!
아래의 요구사항에 맞춰 기획 요건에 대응할 수 있는 코드를 작성해주세요.

</aside>

- 할 일 검색 시 `weather` 조건으로도 검색할 수 있어야해요.
    - `weather` 조건은 있을 수도 있고, 없을 수도 있어요!
- 할 일 검색 시 수정일 기준으로 기간 검색이 가능해야해요.
    - 기간의 시작과 끝 조건은 있을 수도 있고, 없을 수도 있어요!
- JPQL을 사용하고, 쿼리 메소드명은 자유롭게 지정하되 너무 길지 않게 해주세요.

<aside>
💡 필요할 시, 서비스 단에서 if문을 사용해 여러 개의 쿼리(JPQL)를 사용하셔도 좋습니다.

</aside>

### **4. 테스트 코드 퀴즈 - 컨트롤러 테스트의 이해**

- 테스트 패키지 `org.example.expert.domain.todo.controller`의
  `todo_단건_조회_시_todo가_존재하지_않아_예외가_발생한다()` 테스트가 실패하고 있어요.

- 테스트가 정상적으로 수행되어 통과할 수 있도록 테스트 코드를 수정해주세요.

### **5. 코드 개선 퀴즈 - AOP의 이해**

<aside>
😱 AOP가 잘못 동작하고 있어요!

</aside>

- `UserAdminController` 클래스의 `changeUserRole()` 메소드가 실행 전 동작해야해요.
- `AdminAccessLoggingAspect` 클래스에 있는 AOP가 개발 의도에 맞도록 코드를 수정해주세요.

## Level. 2

### **6. JPA Cascade**

<aside>
🤔 앗❗ 실수로 코드를 지웠어요!

</aside>

- 할 일을 새로 저장할 시, 할 일을 생성한 유저는 담당자로 자동 등록되어야 합니다.
- JPA의 `cascade` 기능을 활용해 할 일을 생성한 유저가 담당자로 등록될 수 있게 해주세요.

### **7. N+1**

- `CommentController` 클래스의 `getComments()` API를 호출할 때 N+1 문제가 발생하고 있어요. N+1 문제란, 데이터베이스 쿼리 성능 저하를 일으키는 대표적인 문제 중 하나로, 특히 연관된 엔티티를 조회할 때 발생해요.
- 해당 문제가 발생하지 않도록 코드를 수정해주세요.
- N+1 로그


### **8. QueryDSL**

TodoService.getTodo 메소드

- JPQL로 작성된 `findByIdWithUser` 를 QueryDSL로 변경합니다.
- 7번과 마찬가지로 N+1 문제가 발생하지 않도록 유의해 주세요!

### **9. Spring Security**

<aside>

⚙️  Spring Security를 도입하기로 결정했어요!

</aside>

- 기존 `Filter`와 `Argument Resolver`를 사용하던 코드들을 Spring Security로 변경해주세요.
  - 접근 권한 및 유저 권한 기능은 그대로 유지해주세요.
  - 권한은 Spring Security의 기능을 사용해주세요.
- 토큰 기반 인증 방식은 유지할 거예요. JWT는 그대로 사용해주세요.

## 5️⃣ 도전 기능

## Level 3

### **10. QueryDSL 을 사용하여 검색 기능 만들기**

<aside>
👉 일정을 검색하는 기능을 만들고 싶어요!
검색 기능의 성능 및 사용성을 높이기 위해 QueryDSL을 활용한 쿼리 최적화를 해보세요.
❗Projections를 활용해서 필요한 필드만 반환할 수 있도록 해주세요❗

</aside>

- 새로운 API로 만들어주세요.
- 검색 조건은 다음과 같아요.
  - 검색 키워드로 일정의 제목을 검색할 수 있어요.
    - 제목은 부분적으로 일치해도 검색이 가능해요.
  - 일정의 생성일 범위로 검색할 수 있어요.
    - 일정을 생성일 최신순으로 정렬해주세요.
  - 담당자의 닉네임으로도 검색이 가능해요.
    - 닉네임은 부분적으로 일치해도 검색이 가능해요.
- 다음의 내용을 포함해서 검색 결과를 반환해주세요.
  - 일정에 대한 모든 정보가 아닌, 제목만 넣어주세요.
  - 해당 일정의 담당자 수를 넣어주세요.
  - 해당 일정의 총 댓글 개수를 넣어주세요.
- 검색 결과는 페이징 처리되어 반환되도록 합니다.

### **11. Transaction 심화**

<aside>
👉 매니저 등록 요청 시 로그를 남기고 싶어요!
`@Transactional`의 옵션 중 하나를 활용하여 매니저 등록과 로그 기록이 각각 독립적으로 처리될 수 있도록 해봅시다.

</aside>

- 매니저 등록 요청을 기록하는 로그 테이블을 만들어주세요.
  - DB 테이블명: `log`
- 매니저 등록과는 별개로 로그 테이블에는 항상 요청 로그가 남아야 해요.
  - 매니저 등록은 실패할 수 있지만, 로그는 반드시 저장되어야 합니다.
  - 로그 생성 시간은 반드시 필요합니다.
  - 그 외 로그에 들어가는 내용은 원하는 정보를 자유롭게 넣어주세요.

### **12. AWS 활용**

<aside>
👉 EC2, RDS, S3를 사용해서 프로젝트를 관리하고 배포합니다.
각 AWS 서비스 간 보안 그룹을 적절히 구성하여 보안에 신경써주세요!

</aside>

**공통사항**

- 각 AWS 서비스의 콘솔에서 내가 만든 서비스들의 설정 화면을 캡쳐하여 `README.md`에 첨부하세요.

**12-1. EC2**

- EC2 인스턴스에서 어플리케이션을 실행하세요.
- 탄력적 IP를 설정해서 외부에서도 접속할 수 있도록 해주세요.
- 서버 접속 및 Live 상태를 확인할 수 있는 health check API를 만들고 `README.md` 에 기재하세요.
  - health check API는 누구나 접속 가능해야 해요.
  - API path는 편하게 정해도 괜찮습니다.

**12-2. RDS**

- RDS에 데이터베이스를 구축하고, EC2에서 실행되는 어플리케이션에 연결하세요.

**12-3. S3**

- S3 버킷을 생성하여 유저의 프로필 이미지 업로드 및 관리 API를 구현하세요.

### **13. 대용량 데이터 처리**

<aside>
❗ RDS를 사용할 경우 과금이 될 수 있어요. 개인 환경에서 테스트해보시는 것을 추천해요.

</aside>

- 대용량 데이터 처리 실습을 위해, *테스트 코드*로 유저 데이터를 100만 건 생성해주세요.
  - 데이터 생성 시 닉네임은 랜덤으로 지정해주세요.
  - 가급적 동일한 닉네임이 들어가지 않도록 방법을 생각해보세요.
- 닉네임을 조건으로 유저 목록을 검색하는 API를 만들어주세요.
  - 닉네임은 정확히 일치해야 검색이 가능해요.
- 여러가지 아이디어로 유저 검색 속도를 줄여주세요.
  - 조회 속도를 개선할 수 있는 여러 방법을 고민하고, 각각의 방법들을 실행해보세요.
  - `README.md` 에 각 방법별 실행 결과를 비교할 수 있도록 최초 조회 속도와 개선 과정 별 조회 속도를 확인할 수 있는 표 혹은 이미지를 첨부해주세요.

## Level 4. Kotlin 적용하기

### 들어가기 전에, Kotlin 전환 간 주의사항

- [ ]  **Kotlin nullable <-> Java Optional**
  - [ ]  Java와 Kotlin을 혼용하여 사용하는 구간에 문제가 발생될 수 있습니다.
  - [ ]  기존 Java에서 Optional로 선언되어 있던 타입을 Kotlin의 Nullable 타입으로 수정 시
    - [ ]  Java에서 이를 사용 할 때, `Optional.ofNullable()`로 감싸야하는 필요성
- [ ]  **Kotlin은 일단 final**
  - [ ]  Kotlin 코드는 기본적으로 `final`임에 주의!
  - [ ]  테스트를 진행할 때 Java 라이브러리로는 Kotlin 코드의 Mocking이 불가능
    - [ ]  이를 가능하게 해주는 `springmockk` 혹은 `mockito-kotlin` 라이브러리를 사용하는 것을 추천

### 프로젝트 세팅하기

- java + kotlin spring 프로젝트 세팅 방법 (기본설정)
  - build.gradle
    - 상단 plugins에 아래 코드를 입력해주세요

        ```jsx
        id 'org.jetbrains.kotlin.jvm' version '2.0.0'  
        id 'org.jetbrains.kotlin.plugin.lombok' version '2.0.0'  
        id 'org.jetbrains.kotlin.plugin.spring' version '2.0.0'  
        id 'org.jetbrains.kotlin.plugin.jpa' version '2.0.0' 
        ```

    - dependencies에 아래 코드를 입력해주세요

        ```jsx
        **implementation "org.jetbrains.kotlin:kotlin-stdlib"
        implementation "org.jetbrains.kotlin:kotlin-reflect"**
        ```

    - allOpen 설정 코드를 하단에 추가해주세요

        ```jsx
        allOpen {
            annotation("jakarta.persistence.Entity")
            annotation("jakarta.persistence.Embeddable")
            annotation("jakarta.persistence.MappedSuperclass")
        }
        ```

    - build.gradle 전문

        ```jsx
        plugins {
            id 'java'
            id 'org.springframework.boot' version '3.3.3'
            id 'io.spring.dependency-management' version '1.1.6'
            id 'org.jetbrains.kotlin.jvm' version '2.0.0'
            id 'org.jetbrains.kotlin.plugin.lombok' version '2.0.0'
            id 'org.jetbrains.kotlin.plugin.spring' version '2.0.0'
            id 'org.jetbrains.kotlin.plugin.jpa' version '2.0.0'
        }
        
        group = 'org.example'
        version = '0.0.1-SNAPSHOT'
        
        java {
            toolchain {
                languageVersion = JavaLanguageVersion.of(17)
            }
        }
        
        configurations {
            compileOnly {
                extendsFrom annotationProcessor
            }
        }
        
        repositories {
            mavenCentral()
        }
        
        dependencies {
            implementation 'org.springframework.boot:spring-boot-starter-validation'
            implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
            implementation 'org.springframework.boot:spring-boot-starter-web'
            compileOnly 'org.projectlombok:lombok'
            runtimeOnly 'com.h2database:h2'
            runtimeOnly 'com.mysql:mysql-connector-j'
            annotationProcessor 'org.projectlombok:lombok'
            testImplementation 'org.springframework.boot:spring-boot-starter-test'
            testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
        
            // bcrypt
            implementation 'at.favre.lib:bcrypt:0.10.2'
        
            // jwt
            compileOnly group: 'io.jsonwebtoken', name: 'jjwt-api', version: '0.11.5'
            runtimeOnly group: 'io.jsonwebtoken', name: 'jjwt-impl', version: '0.11.5'
            runtimeOnly group: 'io.jsonwebtoken', name: 'jjwt-jackson', version: '0.11.5'
        
            //kotlin
            implementation "org.jetbrains.kotlin:kotlin-stdlib"
            implementation "org.jetbrains.kotlin:kotlin-reflect"
        }
        
        tasks.named('test') {
            useJUnitPlatform()
        }
        
        //kotlin
        allOpen {
            annotation("jakarta.persistence.Entity")
            annotation("jakarta.persistence.Embeddable")
            annotation("jakarta.persistence.MappedSuperclass")
        }
        ```

- java + kotlin spring 프로젝트 세팅 방법 (QueryDSL 추가 적용시)
  - build.gradle
    - **상단 토글 java + kotlin spring 프로젝트 세팅 방법 (기본설정)이 되어 있어야합니다.**
    - plugins에 아래 코드를 추가해주세요

        ```jsx
        plugins {  
            // ...
            id 'org.jetbrains.kotlin.kapt' version '2.0.0'  
        }
        ```

    - dependencies에 아래 코드를 입력해주세요

        ```jsx
        dependencies {
            //...
            
            implementation "com.querydsl:querydsl-jpa:5.0.0:jakarta"  
            kapt "com.querydsl:querydsl-apt:5.0.0:jakarta"  
            kapt "jakarta.annotation:jakarta.annotation-api"  
            kapt "jakarta.persistence:jakarta.persistence-api"
        }
        ```

    - kapt 설정 코드를 추가해주세요

        ```jsx
        kapt {  
            keepJavacAnnotationProcessors = true  
        }
        ```

    - build.gradle 전문

        ```jsx
        plugins {
            id 'java'
            id 'org.springframework.boot' version '3.3.3'
            id 'io.spring.dependency-management' version '1.1.6'
            id 'org.jetbrains.kotlin.jvm' version '2.0.0'
            id 'org.jetbrains.kotlin.plugin.lombok' version '2.0.0'
            id 'org.jetbrains.kotlin.plugin.spring' version '2.0.0'
            id 'org.jetbrains.kotlin.plugin.jpa' version '2.0.0'
            id 'org.jetbrains.kotlin.kapt' version '2.0.0'
        }
        
        group = 'org.example'
        version = '0.0.1-SNAPSHOT'
        
        java {
            toolchain {
                languageVersion = JavaLanguageVersion.of(17)
            }
        }
        
        kapt {
            keepJavacAnnotationProcessors = true
        }
        
        configurations {
            compileOnly {
                extendsFrom annotationProcessor
            }
        }
        
        repositories {
            mavenCentral()
        }
        
        dependencies {
            implementation 'org.springframework.boot:spring-boot-starter-validation'
            implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
            implementation 'org.springframework.boot:spring-boot-starter-web'
            compileOnly 'org.projectlombok:lombok'
            runtimeOnly 'com.h2database:h2'
            runtimeOnly 'com.mysql:mysql-connector-j'
            annotationProcessor 'org.projectlombok:lombok'
            testImplementation 'org.springframework.boot:spring-boot-starter-test'
            testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
        
            // bcrypt
            implementation 'at.favre.lib:bcrypt:0.10.2'
        
            // jwt
            compileOnly group: 'io.jsonwebtoken', name: 'jjwt-api', version: '0.11.5'
            runtimeOnly group: 'io.jsonwebtoken', name: 'jjwt-impl', version: '0.11.5'
            runtimeOnly group: 'io.jsonwebtoken', name: 'jjwt-jackson', version: '0.11.5'
        
            //kotlin
            implementation "org.jetbrains.kotlin:kotlin-stdlib"
            implementation "org.jetbrains.kotlin:kotlin-reflect"
        
            //kotlin + QueryDSL
            implementation "com.querydsl:querydsl-jpa:5.0.0:jakarta"
            kapt "com.querydsl:querydsl-apt:5.0.0:jakarta"
            kapt "jakarta.annotation:jakarta.annotation-api"
            kapt "jakarta.persistence:jakarta.persistence-api"
        }
        
        tasks.named('test') {
            useJUnitPlatform()
        }
        
        //kotlin
        allOpen {
            annotation("jakarta.persistence.Entity")
            annotation("jakarta.persistence.Embeddable")
            annotation("jakarta.persistence.MappedSuperclass")
        }
        ```


---

### **14. Entity 및 Repository CRUD 리팩토링(Kotlin)**

- Java로 작성된 Entity 및 CRUD 메서드를 Kotlin으로 리팩토링
  - 프로젝트 세팅 후 Entity, CRUD 요소를 “작게” 리팩토링해봅니다.
  - Todo Entity
    - 코드 보기

        ```java
        package org.example.expert.domain.todo.entity;
        
        import jakarta.persistence.*;
        import lombok.Getter;
        import lombok.NoArgsConstructor;
        import org.example.expert.domain.comment.entity.Comment;
        import org.example.expert.domain.common.entity.Timestamped;
        import org.example.expert.domain.manager.entity.Manager;
        import org.example.expert.domain.user.entity.User;
        
        import java.util.ArrayList;
        import java.util.List;
        
        @Getter
        @Entity
        @NoArgsConstructor
        @Table(name = "todos")
        public class Todo extends Timestamped {
        
            @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;
            private String title;
            private String contents;
            private String weather;
        
            @ManyToOne(fetch = FetchType.LAZY)
            @JoinColumn(name = "user_id", nullable = false)
            private User user;
        
            @OneToMany(mappedBy = "todo", cascade = CascadeType.REMOVE)
            private List<Comment> comments = new ArrayList<>();
        
            @OneToMany(mappedBy = "todo")
            private List<Manager> managers = new ArrayList<>();
        
            public Todo(String title, String contents, String weather, User user) {
                this.title = title;
                this.contents = contents;
                this.weather = weather;
                this.user = user;
                this.managers.add(new Manager(user, this));
            }
        }
        ```

  - Todo 서비스
    - 코드 보기

        ```java
        package org.example.expert.domain.todo.service;
        
        import lombok.RequiredArgsConstructor;
        import org.example.expert.client.WeatherClient;
        import org.example.expert.domain.common.dto.AuthUser;
        import org.example.expert.domain.common.exception.InvalidRequestException;
        import org.example.expert.domain.todo.dto.request.TodoSaveRequest;
        import org.example.expert.domain.todo.dto.response.TodoResponse;
        import org.example.expert.domain.todo.dto.response.TodoSaveResponse;
        import org.example.expert.domain.todo.entity.Todo;
        import org.example.expert.domain.todo.repository.TodoRepository;
        import org.example.expert.domain.user.dto.response.UserResponse;
        import org.example.expert.domain.user.entity.User;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.PageRequest;
        import org.springframework.data.domain.Pageable;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;
        
        @Service
        @RequiredArgsConstructor
        @Transactional(readOnly = true)
        public class TodoService {
        
            private final TodoRepository todoRepository;
            private final WeatherClient weatherClient;
        
            public TodoSaveResponse saveTodo(AuthUser authUser, TodoSaveRequest todoSaveRequest) {
                User user = User.fromAuthUser(authUser);
        
                String weather = weatherClient.getTodayWeather();
        
                Todo newTodo = new Todo(
                        todoSaveRequest.getTitle(),
                        todoSaveRequest.getContents(),
                        weather,
                        user
                );
                Todo savedTodo = todoRepository.save(newTodo);
        
                return new TodoSaveResponse(
                        savedTodo.getId(),
                        savedTodo.getTitle(),
                        savedTodo.getContents(),
                        weather,
                        new UserResponse(user.getId(), user.getEmail())
                );
            }
        
            public Page<TodoResponse> getTodos(int page, int size) {
                Pageable pageable = PageRequest.of(page - 1, size);
        
                Page<Todo> todos = todoRepository.findAllByOrderByModifiedAtDesc(pageable);
        
                return todos.map(todo -> new TodoResponse(
                        todo.getId(),
                        todo.getTitle(),
                        todo.getContents(),
                        todo.getWeather(),
                        new UserResponse(todo.getUser().getId(), todo.getUser().getEmail()),
                        todo.getCreatedAt(),
                        todo.getModifiedAt()
                ));
            }
        
            public TodoResponse getTodo(long todoId) {
                Todo todo = todoRepository.findByIdWithUser(todoId)
                        .orElseThrow(() -> new InvalidRequestException("Todo not found"));
        
                User user = todo.getUser();
        
                return new TodoResponse(
                        todo.getId(),
                        todo.getTitle(),
                        todo.getContents(),
                        todo.getWeather(),
                        new UserResponse(user.getId(), user.getEmail()),
                        todo.getCreatedAt(),
                        todo.getModifiedAt()
                );
            }
        }
        ```

- Nullable 및 Non-Nullable 필드를 정확히 정의하고 데이터 클래스 사용할 것
- 기본 생성자 및 데이터 클래스에서의 `copy()` 메서드 활용할 것
- 기본 `CrudRepository` 또는 `JpaRepository`를 사용할 것
- QueryDSL을 활용할 것
- Lombok을 사용했다면, Kotlin의 기본 기능으로 대체할 것
  - ex) 단순 getter, setter 메서드 생성

### **15. Kotlin으로의 전환**

- 회사에서 기존의 모든 Java 코드를 Kotlin으로 전환하기로 결정했습니다!
- 이번 변경 작업은 엔티티, 서비스, 레포지토리 등 모든 핵심 비즈니스 로직을 포함하며, Kotlin의 장점을 최대한 활용해 코드의 간결성, 안정성, 그리고 생산성을 높이는 데 목표를 둡니다.