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
      <div class="question-description" id="viewer">
        {{ state.question.description }}
      </div>
      <!-- 코멘트 입력하기 -->
    </div>
  </div>
</template>
<script>
import "@/styles/board.scss";
import "@toast-ui/editor/dist/toastui-editor-viewer.css";
// import Viewer from "@toast-ui/editor/dist/toastui-editor-viewer";

import { reactive } from "vue";
import { useRoute } from "vue-router";
import { useStore } from "vuex";

export default {
  name: "board-question",
  setup() {
    const route = useRoute();
    const store = useStore();

    const state = reactive({
      question: null,
      error: "",
    });

    const getQuestion = () => {
      store
        .dispatch("root/requsetBoardInfo", route.params.id)
        .then(
          (response) => {
            state.question = response.data;
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

    return {
      state,
    };
  },
};
</script>
<style></style>
