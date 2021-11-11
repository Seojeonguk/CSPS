<template>
  <div class="info-mini-wrap">
    <div class="left-wrap">
      <div class="open-left-wrap">
        <div class="board-nav">
          <div class="board-btn">
            <div class="btn-board-info">게시판소개</div>
            <div class="row">
              <div class="btn-board-write">
                <q-icon class="write-icon" /> 글작성
              </div>
            </div>
          </div>
          <div class="board-search">
            <q-input label="제목검색" dense>
              <template v-slot:before>
                <q-icon name="search" />
              </template>
            </q-input>
          </div>
          <div class="board-title-list">
            <div class="board-title-list-item">
              <div class="question-list">
                <q-icon class="question-list-icon" />
                <div class="question-list-info">
                  <div class="list-title">제목이라구</div>
                  <div class="list-createdAt">만들어진시간</div>
                  <div class="list-userinfo">
                    <div class="list-user-image">
                      <img
                        class="user-image-circle"
                        :src="require('@/assets/malang.png')"
                      />
                    </div>
                    <div class="list-user-nickName">닉네임</div>
                  </div>
                </div>
              </div>
              <div class="question-list">
                <q-icon class="question-list-icon" />
                <div class="question-list-info">
                  <div class="list-title">제목이라구</div>
                  <div class="list-createdAt">만들어진시간</div>
                  <div class="list-userinfo">
                    <div class="list-user-image">
                      <img
                        class="user-image-circle"
                        :src="require('@/assets/malang.png')"
                      />
                    </div>
                    <div class="list-user-nickName">닉네임</div>
                  </div>
                </div>
              </div>
              <div class="question-list">
                <q-icon class="question-list-icon" />
                <div class="question-list-info">
                  <div class="list-title">제목이라구</div>
                  <div class="list-createdAt">만들어진시간</div>
                  <div class="list-userinfo">
                    <div class="list-user-image">
                      <img
                        class="user-image-circle"
                        :src="require('@/assets/malang.png')"
                      />
                    </div>
                    <div class="list-user-nickName">닉네임</div>
                  </div>
                </div>
              </div>
              <div class="question-list">
                <q-icon class="question-list-icon" />
                <div class="question-list-info">
                  <div class="list-title">제목이라구</div>
                  <div class="list-createdAt">만들어진시간</div>
                  <div class="list-userinfo">
                    <div class="list-user-image">
                      <img
                        class="user-image-circle"
                        :src="require('@/assets/malang.png')"
                      />
                    </div>
                    <div class="list-user-nickName">닉네임</div>
                  </div>
                </div>
              </div>
              <div class="question-list">
                <q-icon class="question-list-icon" />
                <div class="question-list-info">
                  <div class="list-title">제목이라구</div>
                  <div class="list-createdAt">만들어진시간</div>
                  <div class="list-userinfo">
                    <div class="list-user-image">
                      <img
                        class="user-image-circle"
                        :src="require('@/assets/malang.png')"
                      />
                    </div>
                    <div class="list-user-nickName">닉네임</div>
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
        <div class="board-info">
          <div class="info-content first">
            게시판은 <br /><span>CS의 정석</span>을 이용하는 사용자를 위해
            만들었습니다
          </div>
          <div class="info-content second">
            CS지식을 서로 질문하고 공유해 주세요!
          </div>
          <div class="info-content box">게시판 사용에 대한 소개보러가기</div>
          <div class="info-content third">
            <div>무분별한 욕설 및 비방글은 허용하지 않습니다.</div>
            <div>타인에게 불쾌감을 불러 일으키는 글은 자제해주세요.</div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="info-script">{{ state.script }}</div>
</template>
<script>
import "@/styles/information.scss";
import { reactive } from "vue";
export default {
  name: "info-board-main",
  setup() {
    const state = reactive({
      script: "여긴최대 2줄정도 작성해주면되요.",
    });
    return {
      state,
    };
  },
};
</script>
<style scope lang="scss">
.board-btn {
  width: 100%;
  height: 15%;
  font-size: 21px;

  .btn-board-info {
    font-weight: bold;
    margin: 0.5em;
  }
  .btn-board-write {
    margin: 0;
    font-size: 12px;
    text-align: left;
    .write-icon {
      margin-right: 0.15em;
      font-size: 18px;
    }
  }
}
.board-search {
  width: 100%;
  height: 5%;
  margin-bottom: 2em;
  font-size: 12px;
}

.board-title-list {
  width: 100%;
  height: 75%;
  overflow: auto;
  padding: 0em 0em 2em 0em;
}
.board-title-list-item {
  width: 100%;
  margin-bottom: 1em;
}
.question-list {
  display: flex;
  flex-direction: row;
  width: 100%;
  font-size: 18px;

  .question-list-icon {
    margin-right: 0.15em;
  }
}
.question-list:hover {
  cursor: pointer;
  color: black;
  background: #ccd8c8;
  opacity: 0.7;
}
.question-list-info {
  text-align: start;
  width: 90%;
  font-size: 12px;
}
.list-title {
  height: 1em;
  width: 100%;
  font-size: 15px;
}
.list-createdAt {
  font-size: 5px;
  margin-top: 0.5em;
}
.list-userinfo {
  width: 100%;
  margin-top: 0.25em;
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
  align-items: center;

  .list-user-image {
    overflow: hidden;
    border-radius: 50%;
    margin-right: 0.25em;
    .user-image-circle {
      display: block;
      width: 18px;
      height: 18px;
    }
  }
  .list-user-nickName {
    width: 25%;
    margin-right: 0.5em;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
}
.board-info {
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  padding: 2em 1em 2em 1em;
}
.info-content {
  font-size: 12px;
  font-weight: bold;
  span {
    text-shadow: 2px 2px 0 #a2b29f, 2px -2px 0 #a2b29f, -2px 2px 0 #a2b29f,
      -2px -2px 0 #a2b29f, 2px 0 0 #a2b29f, -2px 0 0 #a2b29f, 0 2px 0 #a2b29f,
      0 -2px 0 #a2b29f;
    color: black;
  }
  &.box {
    display: flex;
    align-items: center;
    justify-content: center;
    width: 50%;
    height: 2em;
    margin: 0 auto;
    border: 2px solid #a2b29f;
    border-radius: 1em;
  }
  &.first {
    margin: 0.5em 0em;
    font-size: 24px;
  }
  &.second {
    margin: 1em 0em;
    font-size: 18px;
  }
  &.third {
    margin: 2em 0em 1em 0em;
    color: #a2b29f;
  }
}
</style>
