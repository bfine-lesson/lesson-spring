jenkins

```
docker run -d -p  8080:8080 -p 50000:50000 --name jenkins  jenkins/jenkins:lts
```

deploy.sh
```shell
#!/bin/bash

## 변수 설정
txtrst='\033[1;37m' # White가
txtred='\033[1;31m' # Red
txtylw='\033[1;33m' # Yellow
txtpur='\033[1;35m' # Purple
txtgrn='\033[1;32m' # Green
txtgra='\033[1;30m' # Gray

REPO=
SERVICE= 
BRANCH=$1
VERSION=$2

function git_pull(){
  git pull origin ${BRANCH}
  git checkout ${BRANCH}
}

if [ $# -eq 2 ]; then
  echo -e "${txtylw}=======================================${txtrst}"
  echo -e "${txtgrn}         <<  배포스크립트 >>${txtrst}"
  echo -e "${txtylw}=======================================${txtrst}"
else
  echo -e "${txtred} >> [ERROR] 브렌치 명과 버전을 매개변수로 입력해주세요.\n${txtrst}"
  exit 0
fi


echo -e "\n${txtgrn}>> 실행중인 컨테이너 종료 및 제거 중..\n${txtrst}"

CID=$(docker container ls -f "name=${SERVICE}" -q)
docker stop ${CID} && docker rm ${CID}

echo -e "\n${txtgrn}>> 레포지토리 업데이트[branch=${BRANCH}] \n${txtrst}"
cd ${REPO}
git_pull

echo -e "\n${txtgrn}>> 이미지 빌드 중..\n${txtrst}"
docker build -t ${SERVICE}_${BRANCH}:${VERSION} .

echo -e "\n${txtgrn}>> 컨테이너 배포 중.. \n${txtrst}"
docker run -d -v ~/app/log:/var/log --name=${SERVICE} -p 8080:8080  ${SERVICE}_${BRANCH}:${VERSION}

echo -e "\n${txtgrn}>> 배포 완료 \n${txtrst}"
docker ps
```
cron.sh
```shell

#!/bin/bash

SHELL=/bin/bash
REPO=/home/ubuntu/app/infra-subway-deploy
BRANCH=${1}
VERSION=${2}

function check_diff() {
  git fetch
  master=$(git rev-parse $BRANCH)
  remote=$(git rev-parse origin/$BRANCH)

  if [ $master == $remote ]; then
    echo -e "[$(date)] 변경 없음!!"
    exit 0
  else
    echo -e "[$(date)] 변경 확인 배포 진행"
    source /home/ubuntu/app/deploy.sh $BRANCH $VERSION
  fi
}

cd ${REPO}

check_diff
```
