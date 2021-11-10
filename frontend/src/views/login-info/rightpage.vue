<template>
  <div class="right-wrap">
    <div class="open-right-wrap">
      <div class="inner-wrap">
        <div class="info-contianer">
          <board-info></board-info>
          <board-info></board-info>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import BoardInfo from "./components/board-info.vue";
export default {
  name: "info-right",
  components: {
    BoardInfo,
  },
};
</script>
<style>
.info-contianer {
  width: 100%;
  height: 100%;
  overflow: auto;
}
</style>
