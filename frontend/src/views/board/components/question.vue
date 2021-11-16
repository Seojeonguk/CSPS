<template>
  <div v-if="state.error != ''">{{ state.error }}</div>
  <div v-else>
    <div class="board-question" v-if="state.question != null">
      <div class="question-header">
        <div class="question-title">
          {{ state.question.title }}
        </div>
        <div class="question-delete">
          <div
            class="question-delete-btn"
            v-if="state.question.user.id == state.user.id"
            @click="deleteBoard()"
          >
            삭제
          </div>
        </div>
      </div>
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
      <hr />
      <div class="question-info">
        <div class="question-description" id="viewer"></div>
        <!-- 코멘트 입력하기 -->
        <hr />
        <div class="question-comment">
          <question-answer
            class="question-comment-info"
            v-for="(answer, index) in state.question.answerComment"
            :key="index"
            :answer="answer"
            :comment="state.question.coComment"
          ></question-answer>
          <div style="max-width: 900px" class="row justify-center">
            <q-input
              v-model="answer"
              label="댓글달기"
              @keyup.enter="
                onSubmit();
                $event.target.blur();
              "
            ></q-input>
          </div>
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

import { computed, reactive, onUpdated, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useStore } from "vuex";

export default {
  name: "board-question",
  components: {
    QuestionAnswer,
  },
  data() {
    return {
      answer: "",
    };
  },
  methods: {
    onSubmit() {
      const payload = {
        content: this.answer,
        userId: localStorage.getItem("userId"),
        parentId: 0,
        boardId: this.$route.params.id,
      };
      this.$store
        .dispatch("root/requestWriteComment", payload)
        .then((response) => {
          console.log(response);
        })
        .catch((error) => {
          console.log(error.response.data);
        });
      this.$router.go();
    },
    deleteBoard() {
      //console.log(this.$route.params.id);
      this.$store
        .dispatch("root/requestDelete", this.$route.params.id)
        .then((response) => {
          if (response.data == "success") {
            alert("삭제되었습니다.");
            localStorage.setItem("reload", true);
            this.$router.push({ name: "board-info" });
          }
        })
        .catch((error) => {
          console.log(error.response.data);
        });
    },
  },
  setup() {
    const route = useRoute();
    const store = useStore();
    const router = useRouter();

    const state = reactive({
      error: "",
      question: null,
      viewer: null,
      user: computed(() => JSON.parse(localStorage.getItem("userInfo"))),
    });

    if (localStorage.getItem("reload")) {
      localStorage.removeItem("reload");
      router.go();
    }

    onMounted(() => {
      document
        .getElementById(localStorage.getItem("menu"))
        .classList.remove("click-menu");
      localStorage.removeItem("menu");
      localStorage.setItem("menu", "menuBtn3");
      document
        .getElementById(localStorage.getItem("menu"))
        .classList.add("click-menu");
    });

    const getQuestion = () => {
      store
        .dispatch("root/requsetBoardInfo", route.params.id)
        .then(
          (response) => {
            console.log(response.data);
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

    onUpdated(() => {
      state.viewer = new Viewer({
        el: document.querySelector("#viewer"),
        initialValue: state.question.description,
        height: document.querySelector(".question-info").clientHeight,
      });
    });

    return {
      state,
      onMounted,
    };
  },
};
</script>
<style></style>
