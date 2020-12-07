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

# 9주차
## 1. 키트 오류
어플을 완성하기전 라즈베이파이와 안드로이드 스튜디오 연결을 위해 키트를 셋팅하는 과정에서 오류가 발생하였다. 
### ACT LED 미작동
![KakaoTalk_20201029_175836674](https://user-images.githubusercontent.com/62588402/97810964-e831ba80-1cba-11eb-94ed-1b983bfc403f.jpg)
사진과 같이 ACT 부분에 LED가 점등이 되지않아서 키트 실행이 안된다.
### 세팅과정
키트를 작동하기 전에 Etcher을 이용해 2번째 사진의 이미지파일을 압축하여 키트안에 저장해야 한다. 여기까진 정상적으로 이루어졌다
![KakaoTalk_20201029_180040459](https://user-images.githubusercontent.com/62588402/97810966-e9fb7e00-1cba-11eb-9c8d-e0698b13c925.png)
![KakaoTalk_20201029_180041965](https://user-images.githubusercontent.com/62588402/97810970-eb2cab00-1cba-11eb-9acc-f7bea209bf05.png)

하지만 그 이후에 ACT 부분 LED가 점등이 되질않아 작동이 안되었고 인터넷에서 원인을 찾아보니 이러한 현상은 MAC OS에서 자주 발생되는 것이지만 windows에서는 드물게 발생되는 문제이고 SD카드 문제라는 것을 인식해 여분의 SD카드를 사용해봤지만 결과는 마찬가지였다. 혹시나 포멧을 하고 다시 세팅을 하였지만 여전히 작동이 되질않았고 키트 문제일 가능성이 커 10주차 화요일 수업때 키트를 교체할 것이다.

# 10주차
## 1.키트 교체
보드불량인 키트를 교체 완료 하였다.
## 2. Open CV 설치
한글패치와  Open CV 설치를 완료하였다.
## 3. 앱 최종 마무리
일정 제목과 시간 날짜를 설정 후 저장하면 일정이 저장된다.
### 실행화면
![KakaoTalk_20201109_035650942_03](https://user-images.githubusercontent.com/62588402/98482028-e2e7e900-2241-11eb-8611-6295b54dcd07.png)
![KakaoTalk_20201109_035650942_02](https://user-images.githubusercontent.com/62588402/98482032-ea0ef700-2241-11eb-9a8b-d62ef5298690.png)
![KakaoTalk_20201109_035650942_01](https://user-images.githubusercontent.com/62588402/98482035-ed09e780-2241-11eb-9ac8-ed57a6430fad.png)
![KakaoTalk_20201109_035650942](https://user-images.githubusercontent.com/62588402/98482036-eed3ab00-2241-11eb-888a-9828b00e7a2d.png)

# 11주차
## 1.음성출력은 어떻게 할 것인가?
### 인드로이드 스튜디오 TTS 활용
![1](https://user-images.githubusercontent.com/62588402/99192660-54321980-27b7-11eb-8264-18ae75434864.png)

안드로이드 스튜디오에서 제공하는 TTS를 이용하는 방법이다. EditText에 text를 입력하고 버튼을 누르면 text값을 음성으로 출력하게 해주는 것이다. 그런데 우리는 사용자가 직접 설정한 시간에 맞게 음성을 출력이 되어야 하므로 알람을 응용하는 방식으로 사용하고자 한다. 결론은 앱자체에서 음성출력을 하게끔 설정하고 라즈베리파이는 음성을 전달해주게 하는 구조이다.

### 라즈베리파이를 이용한 TTS 활용
앱자체에서 음성출력이 가능하다해도 라즈베리파이에서 제공되는 오픈소스로 공개된 TTS를 사용해야 음성이 출력이 된다. 먼저 라즈베리파이로 각 필요한 패키지들을 설치 후 설정을 해줘야 한다.

## 2. 키트에 어떻게 시간을 출력 할 것인가?
![22](https://user-images.githubusercontent.com/62588402/99193268-4a121a00-27bb-11eb-85ad-21c58b471d8b.png)

제공된 FND를 이용해서 시간을 출력하는 방법이다. 우선 라즈베리파이 내의 시간을 현재시간과 동일하게 설정 후 코드를 작성하면 된다.

# 12주차
## 설정한 시간에 앱에서 음성출력이 가능하게 앱 수정
### TTS 구현
우선 간단하게 일정을 입력하고 날짜와 시간을 설정한뒤에 일정추가 버튼을 누르면 즉시 음성이 출력이 되게 구현해보았다
![KakaoTalk_20201123_020300247](https://user-images.githubusercontent.com/62588402/99910225-28231500-2d30-11eb-95da-01442801c720.png)
### 코드사진
![tts1](https://user-images.githubusercontent.com/62588402/99910125-af23bd80-2d2f-11eb-85eb-8267a8be5308.PNG)
![tts2](https://user-images.githubusercontent.com/62588402/99910126-b054ea80-2d2f-11eb-98eb-c5fe7c51a329.PNG)
### 우리가 원하는 것은?
방금과 같이 버튼을 누르면 즉시 음성이 출력이 아니라 시간에 맞춰서 음성을 출력해주는 것이다. 그러기 위해선 알람시계 원리를 이용하는 것을 시도해 보았다.
진행중..

# 13주차 
## 1. 라즈베리파이 내의 시간을 현재시간으로 설정 후 FND에 시간이 출력 할수 있게
라즈베리파이로 FND에 시간이 출력을 하려면 아두이노와 연동을 해야한다. 기본적으로 파이와 아두이노가 정상적으로 연동이 되었는지 다음 영상과 같이 테스트를 해보았다.
### 테스트 코드
간단한 테스트를 위해 아두이노에 연결된 LED에 불이 깜빡이게 하는 코드이다.

![KakaoTalk_20201126_191526414](https://user-images.githubusercontent.com/62588402/100644587-da855880-337e-11eb-9e13-64ce6aa0a91c.jpg)
### 실행영상
테스트한 결과 정상적으로 연동이 되었다

![202020](https://user-images.githubusercontent.com/62588402/100644557-ce999680-337e-11eb-97cc-aa69a6a4adac.gif)

### 문제점
이제 FND에 시간이 출력이 되게 해야하는데 기존에 지급받은 FND로는 구현이 어려울거 같아 실시간 시계모듈과 변환모듈을 추가로 구입하였고 부품이 생각보다 일찍도착해 14주차때 구현할 예정이다.

![KakaoTalk_20201127_104537434](https://user-images.githubusercontent.com/62588402/100644956-567fa080-337f-11eb-9459-baed785bc6ec.png)

## 2. 12주차때 구현하려던 설정 시간에 TTS출력하기
12주차때 이미 구현이 완료되어야 했지만 중간중간 오류가 발견되어 14주차때 최종 구현이 완료될 것 같다.

# 14주차
## 캘린더 앱 최종 구현
일정을 입력하고 일정추가버튼을 누르면 날짜와 시간설정이 나오고 설정후에 설정해준 시간에 맞춰서 AlarmActivity가 출력되면서 음성으로 일정과 시간을 출력해준다.
### 실행영상
https://www.youtube.com/watch?v=Qvr9NcF2fNM&feature=youtu.be

## AlarmActivity
![aa](https://user-images.githubusercontent.com/62588402/101357638-0fdcf980-38dd-11eb-904d-e406158553d3.PNG)
시간에 맞춰 AlramActivity에서 입력한 일정이 textview로 출력되어지고 일정과 시간을 TTS를 활용해 음성을 출력해준다

## AlarmReceiver
![ar](https://user-images.githubusercontent.com/62588402/101357642-110e2680-38dd-11eb-9d5a-824caa2dec5e.PNG)
시간에 맞춰 알람이 울리게 하는 기능을 수행한다.

## 라즈베리파이와 휴대폰 간 블루투스 연결이 되도록 설정
파이에 블루투스를 사용하기 위한 모듈을 설치 후 휴대폰과 라즈베리파이를 연동해 보았다.
### 실행사진
![KakaoTalk_20201207_224317473_01](https://user-images.githubusercontent.com/62588402/101358217-e2dd1680-38dd-11eb-8fc2-b3636bbeb1f1.jpg)
![KakaoTalk_20201207_224317473](https://user-images.githubusercontent.com/62588402/101358222-e40e4380-38dd-11eb-82b8-c03041f22999.jpg)

![KakaoTalk_20201207_224317473_02](https://user-images.githubusercontent.com/62588402/101358225-e40e4380-38dd-11eb-8c2c-521626b27b36.png)

