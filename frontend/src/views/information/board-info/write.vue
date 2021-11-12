<template>
  <div class="info-wrap">
    <div class="info-mini-wrap">
      <div class="left-wrap">
        <div class="open-left-wrap">
          <div class="info-action-btn" @click="addInfoAction">
            <q-icon></q-icon>
          </div>
          <div class="board-nav">
            <div class="information-board-btn">
              <div class="information-btn-board-info">게시판소개</div>
              <div class="row">
                <div class="information-btn-board-write">
                  <q-icon
                    class="information-write-icon write-icon"
                    name="border_color"
                  />
                  글작성
                </div>
              </div>
            </div>
            <div class="information-board-search">
              <q-input label="제목검색" dense>
                <template v-slot:before>
                  <q-icon name="search" />
                </template>
              </q-input>
            </div>
            <div class="information-board-title-list">
              <div class="information-board-title-list-item">
                <div class="information-question-list">
                  <q-icon class="information-question-list-icon" />
                  <div class="information-question-list-info">
                    <div class="information-list-title">React 질문있어요</div>
                    <div class="information-list-createdAt">2021-11-12</div>
                    <div class="information-list-userinfo">
                      <div class="information-list-user-image">
                        <img
                          class="information-user-image-circle"
                          :src="require('@/assets/malang.png')"
                        />
                      </div>
                      <div class="information-list-user-nickName">
                        React뿌수기
                      </div>
                    </div>
                  </div>
                </div>
                <div class="information-question-list">
                  <q-icon class="information-question-list-icon" />
                  <div class="information-question-list-info">
                    <div class="information-list-title">
                      Vue3 는 Vue2 라이브러리 지원 안되나요?
                    </div>
                    <div class="information-list-createdAt">2021-11-01</div>
                    <div class="information-list-userinfo">
                      <div class="information-list-user-image">
                        <img
                          class="information-user-image-circle"
                          :src="require('@/assets/malang.png')"
                        />
                      </div>
                      <div class="information-list-user-nickName">지원</div>
                    </div>
                  </div>
                </div>
                <div class="information-question-list">
                  <q-icon class="information-question-list-icon" />
                  <div class="information-question-list-info">
                    <div class="information-list-title">
                      How to use join query in database
                    </div>
                    <div class="information-list-createdAt">2021-10-31</div>
                    <div class="information-list-userinfo">
                      <div class="information-list-user-image">
                        <img
                          class="information-user-image-circle"
                          :src="require('@/assets/malang.png')"
                        />
                      </div>
                      <div class="information-list-user-nickName">디비장인</div>
                    </div>
                  </div>
                </div>
                <div class="information-question-list">
                  <q-icon class="information-question-list-icon" />
                  <div class="information-question-list-info">
                    <div class="information-list-title">
                      docker환경설정좀 봐주세요
                    </div>
                    <div class="information-list-createdAt">2021-10-21</div>
                    <div class="information-list-userinfo">
                      <div class="information-list-user-image">
                        <img
                          class="information-user-image-circle"
                          :src="require('@/assets/malang.png')"
                        />
                      </div>
                      <div class="information-list-user-nickName">
                        배포실패자
                      </div>
                    </div>
                  </div>
                </div>
                <div class="information-question-list">
                  <q-icon class="information-question-list-icon" />
                  <div class="information-question-list-info">
                    <div class="information-list-title">
                      Fonrtend Javascript animation is not working
                    </div>
                    <div class="information-list-createdAt">2021-10-15</div>
                    <div class="information-list-userinfo">
                      <div class="information-list-user-image">
                        <img
                          class="information-user-image-circle"
                          :src="require('@/assets/malang.png')"
                        />
                      </div>
                      <div class="information-list-user-nickName">
                        Front Master
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="right-wrap">
        <div class="open-right-wrap">
          <div
            class="column justify-center items-center"
            style="width: 100%; height: 100%"
          >
            <img
              :src="require('@/assets/boardwrite.png')"
              style="width: 90%; height: 90%; border-radius: 30px"
            />
          </div>
        </div>
      </div>
    </div>
    <div class="info-script">{{ state.script }}</div>
    <div class="info-warn">상기 모든 내용은 임의로 작성되었습니다.</div>
  </div>
</template>
<script>
import { reactive } from "vue";
export default {
  name: "info-board-write",
  setup() {
    const state = reactive({
      editor: null,
      script: "아 진짜 모르겠다",
    });
    return { state };
  },
};
</script>
<style lang="scss">
.information-board-btn {
  width: 100%;
  height: 15%;
  font-size: 21px;

  .information-btn-board-info {
    font-weight: bold;
    margin: 0.5em;
  }
  .information-btn-board-write {
    margin: 0;
    font-size: 12px;
    text-align: left;
    .information-write-icon {
      margin-right: 0.15em;
      font-size: 18px;
    }
  }
}
.information-board-search {
  width: 100%;
  height: 5%;
  margin-bottom: 2em;
  font-size: 12px;
}

.information-board-title-list {
  width: 100%;
  height: 75%;
  overflow: auto;
  padding: 0em 0em 2em 0em;
}
.information-board-title-list-item {
  width: 100%;
  margin-bottom: 1em;
}
.information-question-list {
  display: flex;
  flex-direction: row;
  width: 100%;
  font-size: 18px;

  .information-question-list-icon {
    margin-right: 0.15em;
  }
}
.information-question-list:hover {
  cursor: pointer;
  color: black;
  background: #ccd8c8;
  opacity: 0.7;
}
.information-question-list-info {
  text-align: start;
  width: 90%;
  font-size: 12px;
}
.information-list-title {
  height: 1em;
  width: 100%;
  font-size: 15px;
}
.information-list-createdAt {
  font-size: 5px;
  margin-top: 0.5em;
}
.information-list-userinfo {
  width: 100%;
  margin-top: 0.25em;
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
  align-items: center;

  .information-list-user-image {
    overflow: hidden;
    border-radius: 50%;
    margin-right: 0.25em;
    .information-user-image-circle {
      display: block;
      width: 18px;
      height: 18px;
    }
  }
  .information-list-user-nickName {
    width: 25%;
    margin-right: 0.5em;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
}
</style>
