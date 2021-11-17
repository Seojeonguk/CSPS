 <p align="center"><img src="README.assets/cs_main.JPG" width="400" height="200" /></p>




## 👨‍👩‍👦팀원 소개
**이조순**

- 🌰Github: [@LEE JO SUN](https://github.com/KingBlackCow)







## 📆 프로젝트 개요

- 진행 기간 : 2021.10.11 ~ 2021.11.19

- 서비스명 : CS의 정석
- 목표 : Computer Science 역량 향상을 위한 음성 인식 퀴즈 웹 서비스
   - 퀴즈 형태로 나오는 CS지식을 음성인식을 통해 말하면서 학습할 수 있다.
   - 결과 그래프를 통해 자신이 부족한 부분을 확인하여 집중적으로 학습할 수 있다.
   - 이전 자신의 데이터와 비교하여 실력을 분석할 수 있다.
   - 게시판을 제작하여 사용자들끼리 의견을 공유할 수 있다.

- [와이어프레임]
- [ERD]
- [API]

<br>



## ✍ 프로젝트 소개

CS의 정석은 개발자들의 Computer Science 역량을 강화하기 위해 개발하였습니다.<br>
각종 부트캠프들로 가운데 신입 개발자들의 코딩 실력과 개발 실력이 높아지고 있지만,<br>
Computer Science를 제대로 공부하지 못하여 기술면접에 어려움을 겪는 개발자들이 많습니다.<br>
저희는 책과 블로그로만 익히는 Computer Science 지식을 더욱 능동적으로 학습하여 학습의 효율을 올리고 <br>
이를 음성 인식을 통해 답을 인식하는 Computer Science 퀴즈 웹서비스를 제안하고자 합니다.

## ⭐️주요 기능

### OOOO 서비스 

> 회원가입시 단 6개의 추천으로 나와 맞는 최고의 지역을 추천해드립니다.  

- 한국관광공사의 `국민여행조사 2020 국내여행` 을 기반으로 데이터 전처리 
- 상관 관계 분석으로 6개의 주요 변수 추출 
- 랜덤 포레스트 기반 모델

### 리뷰로 분석하는 최고의 관광지 추천 서비스  

> 1개만의 리뷰로도 빅데이터 기반 맞춤형 관광지를 추천해드립니다.

- 한국관광공사의 `국문 관광정보 데이터 ` 에 존재하는 관광지 리뷰를 카카오에서 크롤링
- Cosine Similarity를 통한 유저간의 유사도 측정
- 98명의 페르소나로 차원 축소 
- SVD(특이값 분해) 모델 

### 나만의 여행경로

> 여행가기전에 경로를 미리 짜볼 수 있습니다. 

- kakao map API 를 사용하여 지도를 보여줌
- 5가지 테마로 분류해 마커로 표시 
- 선택한 관광지를 기반으로 경로를 표시하고 저장



<br>

## ❔ 서비스 아키텍쳐

![image-20211007113705334](README.assets/image-20211007113705334.png)





## 🎞 최종산출물

- [시연 영상](https://youtu.be/qct8XHwHFrs)

- [발표영상 pdf]



## 😋 Installation

### ✨Front-End 

- **지원 환경** : Web
- **담당자** : 김용재, 이조순, 차범희

<details>
    <summary>Front 자세히 살펴보기 🌈</summary>
    <ul>
        <li>기술스택 ⚙</li>
    </ul>   
    <ul>
        <li>JS, HTML, CSS</li>
        <li>SCSS</li>
        <li>Vue.js @2.6.11</li>
    </ul>
    <li>--------------------------------------------------------------------------------------</li>
    <ul>
        <li>라이브러리 📚</li>
    </ul>   
    <ul>
        <li>axios</li>
        <li>eslint & prettier</li>
        <li>node-sass</li>
        <li>sass-loader</li>
        <li>@fortawesome/fontawesome-svg-core</li>
        <li>@fortawesome/free-regular-svg-icons</li>
        <li>ant-design-vue</li>
        <li>aos</li>
        <li>bootstrap</li>
        <li>bootstrap-vue</li>
        <li>jwt-decode</li>
        <li>less-loader</li>
        <li>v-calendar</li>
        <li>vue-compare-image</li>
        <li>vue-easy-range-date-picker</li>
        <li>vue-google-login</li>
        <li>vue-infinite-loading</li>   
        <li>vue-typer</li>
        <li>vue2-datepicker</li>
        <li>vue2-daterange-picker</li>
        <li>vuejs-countdown</li>
        <li>vuelendar</li>
        <li>vuelidate</li>
        <li>vuetify</li>
        <li>vuetify-image-input</li>
        <li>vuex</li>
        <li>vuex-persistedstate</li>
        <li>webstomp-client</li>
        <li>d3</li>
        <li>jquery</li>
    </ul>
</details>



### 💻Back-End

- **담당자** : 김윤빈, 임광훈
<details>
    <summary>Front 자세히 살펴보기 🌈</summary>
    <ul>
        <li>기술스택 ⚙</li>
    </ul>   
    <ul>
        <li>Django</li>
        <li>AWS EC2</li>
        <li>Docker</li>
        <li>Jenkins</li>
        <li>Mariadb</li>
        <li>AWS S3</li>
    </ul>
    <li>--------------------------------------------------------------------------------------</li>
    <ul>
        <li>라이브러리 📚</li>
    </ul>   
    <ul>
        <li>Scikit-learn</li>
        <li>djangorestframework-jwt</li>
        <li>gunicorn</li>
        <li>numpy</li>
        <li>pandas</li>
        <li>django-rest-authtoken</li>
        <li>pymongo</li>
        <li>python-dateutil</li>
        <li>pytz</li>
        <li>requests</li>
        <li>scipy</li>
        <li>six</li>
        <li>sqlparse</li>
        <li>threadpoolctl</li>
        <li>urllib3</li>
        <li>TruncatedSVD</li>
        <li>svds</li>
    </ul>
</details>






