<template lang="">
  <div class="info-mini-wrap">
    <div class="left-wrap">
      <div class="open-left-wrap"></div>
    </div>
    <div class="right-wrap">
      <div class="open-right-wrap"></div>
    </div>
  </div>
  <div class="info-script">{{ state.script }}</div>
  <div class="info-warn">상기 모든 내용은 임의로 작성되었습니다.</div>
</template>
<script>
import { reactive } from "vue";
export default {
  name: "info-problem-result",
  setup() {
    const state = reactive({
      script: "아 진짜 모르겠다",
    });
    return { state };
  },
};
</script>
<style lang=""></style>
