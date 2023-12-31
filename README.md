# EzOrder
```
사용자 위치기반 카페 주문 어플리케이션  
관리자, 가게, 고객 입장에서 필요한 기능을 제공하는 안드로이드 프로젝트
```
## 개발 기간
* 2023.8.16 ~ 2023.8.30
## 주요 기능
### 관리자
* 가게 등록 관리
### 가게
* 카페 메뉴 등록 및 관리
* 주문이 들어오면 알람을 통해 이를 알리고 가게에 주문된 리스트 확인
* 주문에 대한 준비가 끝나면 고객에게 요청완료 알람을 보낸다
### 고객
* 지도를 통해 앱에 등록된 가게를 확인
* 주문을 할 가게를 선택하고 메뉴를 골라 주문을 요청한다
* 음료 준비가 되어 가게측에서 요청 완료 알람을 보내면 알람을 받아 확인한다
* 주문 리스트에는 지금 진행중인 주문과 이때까지 주문했던 주문들을 확인한다
## 프로젝트 구성도

|시스템 구성|
|:----:|
|![](/assets/images/230907143228.png)|

|ERM|
|:---:|
|![](/assets/images/230907143719.png)|



## 실행 화면
<details>
<summary>접기</summary>

#### 관리자
![](/assets/images/230907145034.png)
#### 가게
![](/assets/images/230907145216.png)
#### 고객
![](/assets/images/230907145359.png)
#### 주문
![](/assets/images/230907145547.png)
#### 알람
![](/assets/images/230907145737.png)

</details>

## 기술 스택  
* **Android**
  * Java
  * Naver Map api
  * Firebase FCM
  * Retrofit2
  * **Tool** : Android Studio
* **Back-end**
  * Java
  * Spring boot
  * Spring Data JPA
  * MySQL #Database
  * **Tool** : STS4
## 팀원
* 김명준
* 김성민
* 설성칠
* 하재민
 
