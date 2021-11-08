<template lang="">
  <div class="board-question">
    <!-- <div class="question-title">{{ question.title }}</div>
    <div class="question-createdAt">{{ question.createdAt }}</div>
    <div class="question-user">
      <div class="question-user-image">
        <img :src="question.user.image" class="question-user-image-circle" />
      </div>
      <div class="question-user-nickName">
        {{ question.user.nickName }}
      </div>
    </div>
    <div class="question-description" id="viewer"></div> -->
    <!-- 코멘트 입력하기 -->
  </div>
</template>
<script>
import "@/styles/board.scss";
import "@toast-ui/editor/dist/toastui-editor-viewer.css";
// import Viewer from "@toast-ui/editor/dist/toastui-editor-viewer";

// import { reactive, onMounted, watch } from "vue";
import { reactive } from "vue";
export default {
  name: "board-question",
  props: {
    question: {
      id: Number,
      title: String,
      description: String,
      user: Object,
      createdAt: String,
      answerComment: Array,
      coComment: Array,
    },
  },
  setup(props) {
    console.log(props.question);
    const state = reactive({
      viewer: null,
    });
    // onMounted(() => {
    //   state.viewer = new Viewer({
    //     el: document.querySelector("#viewer"),
    //     initialValue: props.question.description,
    //   });
    // });

    // watch(
    //   () => props.question.description,
    //   () => {
    //     state.viewer = new Viewer({
    //       el: document.querySelector("#viewer"),
    //       initialValue: props.question.description,
    //     });
    //   }
    // );

    return { state };
  },
};
</script>
<style></style>
