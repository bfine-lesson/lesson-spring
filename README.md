# 2주차

### 1. REST API 의 특징에 대해 설명해보세요

~~~
 1. Server-Client 구조
 2. 무상태성 - client의 context를 server에 저장하지 않는다.
 3. Cacheable - 캐시사용이 가능해서 응답 시간을 빠르게 할 수 있다.
~~~

---

### 2. REST API 의 단점에 대해 설명해보세요

~~~
 1. HTTP 프로토콜에 의존 → 메소드 형태가 제한적
 2. 표준의 부재
    -> 관리의 어려움과 좋은(공식화 된) API 디자인 가이드가 존재하지 않음
~~~

--- 

### 3. @RequestBody vs @ModelAttribute 설명해보세요

~~~
 공통점
    - 클라이언트 측에서 보낸 데이터를 Java 코드에서 사용할 수 있는 오브젝트로 만들어준다.
 @RequestBody
    - 클라이언트가 보내는 HTTP 요청 본문(JSON 및 XML 등)을 Java 오브젝트로변환하는 것
    - HttpMessageConverter를 통해 타입에 맞는 객체로 변환
    - 생성자와 Setter가 없어도 가능
        - MappingJackson2HttpMessageConverter를 사용함
        - 직렬화를 위해 기본 생성자는 필수
        - 데이터 바인딩을 위한 필드명을 알아내기 위해 getter나 setter 중 1가지는 정의
 @ModelAttribute
    - 클라이언트가 보내는 HTTP 파라미터들을 특정 Java Object에 바인딩(맵핑)하는 것
    - 객체의 필드에 접근해 데이터를 바인딩할 수 있는 생성자 혹은 setter 메서드가 필요하다.
    - Query String 및 Form 형식이 아닌 데이터는 처리할 수 없다.
    
 참고 : https://tecoble.techcourse.co.kr/post/2021-05-11-requestbody-modelattribute/
~~~

---

### 4. @Controller vs @RestController 차이와 @RestController 사용했을때 Spring MVC 설정의 변화를 설명해보세요

~~~
 차이점
    - HTTP Response Body 생성되는 방식
    - @Controller는 뷰를 반환하기 위한 목적이고, @RestController는 데이터를 반환하기 위한 목적
    
 @RestController 사용 시 Spring MVC 설정 변화
    - @RestController 사용 시 객체를 반환하기 때문에 HttpStatus를 설정할 수 없음 → 객체를 상황에 맞는 ResponseEntity로 감싸서 반환해야 함
 참고 : https://mangkyu.tistory.com/49
~~~

---

### 5. DAO vs Repository 차이를 설명해보세요

~~~
 - 차이점
    DAO - 퍼시스턴스 레이어, DB와 가까운 존재
    Repository - 도메인 레이어, 도메인과 가까운 존재
    Repository 에서는 기본 스토리지에 접근하기 위해 DAO 사용가능
~~~

--- 

### 6. Build Tool 에 대해 설명해 보세요

~~~
 - 빌드 도구란?
    - 소스 코드를 컴파일, 테스트, 정적분석 등을 실행하여 실행 가능한 애플리케이션으로 자동 생성하는 프로그램
    - 계속해서 늘어나는 라이브러리 자동 추가 및 관리
    - 프로젝트를 진행하며 시간이 지남에 따라 라이브러리의 버전을 자동으로 동기화
- 종류 및 특징
    - Maven
        - 특징
            - 프로젝트에 필요한 모든 종속성(Dependency)를 리스트의 형태로 Maven에게 알려서 종속성을 관리
            - 자동으로 필요한 라이브러리 파일을 불러옴
        - 단점
            - 라이브러리가 서로 종속 시 XML 복잡
    - Gradle
        - 특징
            - JVM 기반의 빌드도구
            - 오픈소스 기반의 Build 자동화 도구
        - 장점
            - 설정 시간 절약
~~~

---

### 7. 쇼핑 사이트에서 Http Request Header를 하나하나 분석해 보세요

~~~

~~~

--- 

