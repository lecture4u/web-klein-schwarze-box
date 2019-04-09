# web-klein-schwarze-box
implementation of Klein Schwarze box which is a java blockchain skeleton on web


## 1. front: Vue-cli
vue cli 3.0 or later

function: routing, rendering

use axios for retrieving data from api server

#### installation
``` bash
npm install -g @vue/cli
```

#### run
``` bash
cd klein-schwarze-box
npm install
npm run serve
```
```diff
IMPORTANT: before run vue-cli dev server, please check if api server is running. if run api server after running vue dev server, there must be problem
```


## 2. backend: Springboot
springboot 2.1.3

use gradle instead of maven
