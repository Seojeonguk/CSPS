<template lang="">
  <div>
    <div v-if="state.error != ''">{{ state.error }}</div>
    <div v-else>
      <div v-for="(board, idx) in state.boards" :key="board.id">
        <span>{{ idx + 1 }}</span>
        <span>{{ board.title }}</span>
        <span>{{ board.createDate }}</span>
      </div>
    </div>
  </div>
</template>
<script>
import { reactive } from "vue";
import { useStore } from "vuex";

export default {
  setup() {
    const store = useStore();
    const state = reactive({
      user: JSON.parse(localStorage.getItem("userInfo")),
      error: "",
      boards: [],
    });
    const getUserBoard = () => {
      store
        .dispatch("root/requestUserBoardList", state.user.id)
        .then(
          (response) => {
            state.boards = response.data;
          },
          (error) => {
            state.error = error.response.data.message;
          }
        )
        .catch((error) => {
          console.log(error);
        });
    };

    getUserBoard();

    return {
      state,
      getUserBoard,
    };
  },
};
</script>
<style lang=""></style>
