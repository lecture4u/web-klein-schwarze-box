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
- IMPORTANT: before run vue-cli dev server, please check if api server is running. if run api server after running vue dev server, there must be problem
```

front dev server is on localhost:8080 refer to vue-cli instruction

## 2. backend: Springboot 2.1.3

dependency mgmt: use **gradle** instead of maven(~~love gradle!~~)

deploy server is on localhost:3000 refer to application-properties.yml, which spcifies springboot configuration
