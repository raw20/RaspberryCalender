# smile16 (임베디드 시스템 설계)
# 1주차

## 조편성
1. 오준석 (201621204, 조장)
2. 정찬욱 (201621220)
3. 서형욱 (201621200)
4. 박지우 (201621198)
5. 한승주 (201621228)
6. 최영준 (201621226)

# 2주차
## 주제
음성 알림 서비스가 가능한 디지털 시계

## 주제의 차별화
1. 디지털 시계에 스피커를 장착한다.
2. 시간은 LED로 출력한다.
3. 라즈베이파이와 연동가능한 캘린더 앱을 만든다.
4. 캘린더에 일정을 작성하면 그 시간대에 디지털시계에서 음성으로 일정을 출력해준다.

## 기술난이도
1. 라즈베리파이와 연동가능한 캘린더 앱만들기
  - 1학기에 배운 스모프를 바탕으로 안드로이스 스튜디오를 통해 캘린더 앱을 제작하고 라즈베이파이와 연동.(난이도 중)
2. LED로 실시간으로 시간을 출력하기
  - 구글링을 통해서 하면 생각보다 오래 걸리지는 않을 것 같다 (난이도 중하)
3. 스피커를 연동하고 앱에서 설정한 일정을 음성으로 시간대에 맞춰서 출력하기
  - 3주차에 조원들과 어떤방향으로 알고리즘을 만들고 어떤 식으로 진행할 것인지 의논할 것이다. (난이도 상) 
 
 ## 비용
![그림01](https://user-images.githubusercontent.com/62588402/93013081-288c8a80-f5e0-11ea-857e-b9b536ab9b96.jpg)
![그림02](https://user-images.githubusercontent.com/62588402/93013092-39d59700-f5e0-11ea-9285-035127fe6257.jpg)

## 기간
기말고사 이전까지

## 예상되는 문제점
1. 엡과 라즈베리파이의 연동이 잘 될수 있을까?
2. 앱에서 설정한 일정을 스피커로 음성출력을 할 수 있을까?


# 4주차
1. 캘린더 앱을 어떤 구성으로 만들 것인지?
2. 안드로이드 스튜디오와 라즈베이파이로 어떻게 연동시킬 것인지?

## 화면구성 (간략하게)
![1](https://user-images.githubusercontent.com/62588402/94361774-d70cf100-00f1-11eb-82a4-0ec00c7a69d2.png)
![2](https://user-images.githubusercontent.com/62588402/94361777-d83e1e00-00f1-11eb-9ce3-dc9fe3322b60.png)

5주차에 이러한 구성으로 안드로이드 스튜디오로 제작한 다음 더 필요한 구성이 생기면 6주차에 추가보고 하겠습니다.

## 안드로이드 스튜디오와 라즈베이파이 연동
블루투스를 활용하는 방법을 이용할 것이다.
먼저 블루투스 통신을 위한 SW을 설치하고 앱에서 라즈베이파이랑 페어링 할수 있도록 구현 할것이다.

# 6주차
1. 캘린더 앱 제작 (1/2)
2. 시계를 만들기 위한 필요물품 구입신청 (7주차에 확인예정)

## 캘린더 앱 제작 (1/2)
### 실행화면
![KakaoTalk_20201012_035800741](https://user-images.githubusercontent.com/62588402/95688398-d1acbc00-0c44-11eb-8d20-5e734c36e9de.png)
1. 간략한 실행화면이다. 그 전달과 그 담달을 확인 할 수 있고 오늘 날짜는 달력에 초록색 글씨로 따로 표시된다.
### 소스코드
![2](https://user-images.githubusercontent.com/62588402/95688107-9f01c400-0c42-11eb-9382-1fadc550e1be.PNG)
1. MaionActivity.class 코드 화면이다. 각 클래스들을 불러와 캘린더 뷰를 뿌려주는 클래스이다.

![3](https://user-images.githubusercontent.com/62588402/95688108-9f9a5a80-0c42-11eb-96eb-c22a873dd11a.PNG)
1. MomthAdaptor.class 코드 화면이다. 달력에 어떻게 달과 요일을 구분하는지 구현하는 함수이다.
2. 즉 날짜를 계산해서 달력을 배열하는데 필요한 함수이다.

![4](https://user-images.githubusercontent.com/62588402/95688109-9f9a5a80-0c42-11eb-8c61-3b5d97380765.PNG)
1. Monthitem.class이다. 배열에 필요한 아이템의 데이터를 만드는 함수이다.
2. 달력이라서 코드는 간단하다.

![5](https://user-images.githubusercontent.com/62588402/95688110-a032f100-0c42-11eb-84f6-7bac69f0c01b.PNG)
1. MonthItemView.class이다. 달력 형식에 맞는 데이터들을 집어넣어 값들을 보여주는 함수이다.
2. day값이 거짓이 아니면 달력에 1일부터 최대31일까지 검은색 글씨로 표시된다. (토요일, 일요일 색깔구분). 단 day값이 오늘 날짜면 초록색 텍스트로 표시된다.

## 7주차
팀원들이 각자 중간고사 준비로 인해 만나지 못했습니다.

## 8주차 계획
1. 캘린더 앱에서 일정 추가 기능을 구현 (시간설정 가능하게)
2. 구입물품 확인 및 키트 점검 -> 구입할 물품 없는것으로 확정

# 9주차
##1. 키트 오류
어플을 완성하기전 라즈베이파이와 안드로이드 스튜디오 연결을 위해 키트를 셋팅하는 과정에서 오류가 발생하였다. 
### ACT LED 미작동
![KakaoTalk_20201029_175836674](https://user-images.githubusercontent.com/62588402/97810964-e831ba80-1cba-11eb-94ed-1b983bfc403f.jpg)
사진과 같이 ACT 부분에 LED가 점등이 되지않아서 키트 실행이 안된다.
### 세팅과정
키트를 작동하기 전에 Etcher을 이용해 2번째 사진의 이미지파일을 압축하여 키트안에 저장해야 한다. 여기까진 정상적으로 이루어졌다
![KakaoTalk_20201029_180040459](https://user-images.githubusercontent.com/62588402/97810966-e9fb7e00-1cba-11eb-9c8d-e0698b13c925.png)
![KakaoTalk_20201029_180041965](https://user-images.githubusercontent.com/62588402/97810970-eb2cab00-1cba-11eb-9acc-f7bea209bf05.png)

하지만 그 이후에 ACT 부분 LED가 점등이 되질않아 작동이 안되었고 인터넷에서 원인을 찾아보니 이러한 현상은 MAC OS에서 자주 발생되는 것이지만 windows에서는 드물게 발생되는 문제이고 SD카드 문제라는 것을 인식해 여분의 SD카드를 사용해봤지만 결과는 마찬가지였다. 혹시나 포멧을 하고 다시 세팅을 하였지만 여전히 작동이 되질않았고 키트 문제일 가능성이 커 10주차 화요일 수업때 키트를 교체할 것이다.

### 10주차 계획
1. 키트 교체 후 세팅
2. 캘린더 어플 최종 마무리
3. 음성출력을 어떻게 구현할 것인지 분석

