<template>
  <div v-if="state.error != ''">{{ state.error }}</div>
  <div v-else>
    <div class="board-question" v-if="state.question != null">
      <div class="question-title">{{ state.question.title }}</div>
      <div class="question-createdAt">{{ state.question.createdAt }}</div>
      <div class="question-user">
        <div class="question-user-image">
          <img
            :src="state.question.user.image"
            class="question-user-image-circle"
          />
        </div>
        <div class="question-user-nickName">
          {{ state.question.user.nickName }}
        </div>
      </div>
      <div class="question-info">
        <div class="question-description" id="viewer"></div>
        <!-- 코멘트 입력하기 -->
        <div class="question-comment">
          <question-answer
            class="question-comment-info"
            v-for="(answer, index) in state.question.answerComment"
            :key="index"
            :answer="answer"
            :comment="state.question.coComment"
          ></question-answer>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import "@/styles/board.scss";
import "@toast-ui/editor/dist/toastui-editor-viewer.css";
import Viewer from "@toast-ui/editor/dist/toastui-editor-viewer";
import QuestionAnswer from "./components/answer.vue";

import { reactive, onUpdated } from "vue";
import { useRoute } from "vue-router";
import { useStore } from "vuex";

export default {
  name: "board-question",
  components: {
    QuestionAnswer,
  },
  setup() {
    const route = useRoute();
    const store = useStore();

    const state = reactive({
      error: "",
      question: null,
      viewer: null,
    });

    const getQuestion = () => {
      store
        .dispatch("root/requsetBoardInfo", route.params.id)
        .then(
          (response) => {
            console.log(response.data);
            state.question = response.data;
            splitDate();
          },
          (error) => {
            state.error = error.response.data.message;
          }
        )
        .catch((error) => {
          console.log(error);
        });
    };
    getQuestion();

    const splitDate = () => {
      let createdAt = state.question.createdAt.split("T");
      state.question.createdAt = createdAt[0] + " " + createdAt[1];
    };

    onUpdated(() => {
      state.viewer = new Viewer({
        el: document.querySelector("#viewer"),
        initialValue: state.question.description,
        height: document.querySelector(".question-info").clientHeight,
      });
    });

    return {
      state,
    };
  },
};
</script>
<style></style>
