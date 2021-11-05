<template>
  <div class="modify-wrap">
    <span class="modify-title">프로필사진 수정하기</span>
    <div class="modify-image">
      <img class="modi-img" :src="state.imageurl" />
      <label for="chooseFile" class="upload-btn">사진변경</label>
      <input
        type="file"
        id="chooseFile"
        name="chooseFile"
        accept="image/*"
        style="display: none"
        @change="loadf"
      />
    </div>
    <div class="submit-wrap">
      <q-btn color="primary" label="수정하기" @click="modifyImg" />
    </div>
  </div>
</template>
<script>
import { ref, reactive } from "vue";

export default {
  name: "modify",
  setup() {
    const modify_form = ref(null);
    const state = reactive({
      user: JSON.parse(localStorage.getItem("userInfo")),
      imageurl: require("../../../assets/malang.png"),
      file: null,
    });

    const loadf = () => {
      var file = document.getElementById("chooseFile");
      console.log(file.files[0]);
      state.imageurl = URL.createObjectURL(file.files[0]);
    };

    const modifyImg = () => {
      alert("프로필사진수정요청");
    };

    return {
      modify_form,
      state,
      loadf,
      modifyImg,
    };
  },
};
</script>
