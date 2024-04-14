package ee419.server.utils;

import lombok.Data;

@Data
public class ResultVo<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> ResultVo<T> success(String message, T data) {
        ResultVo<T> resultVo = new ResultVo<>();
        resultVo.setCode(200);
        resultVo.setMessage(message != null ? message : "Success");
        resultVo.setData(data);
        return resultVo;
    }

    public static <T> ResultVo<T> error(Integer code, String message) {
        ResultVo<T> resultVo = new ResultVo<>();
        resultVo.setCode(code);
        resultVo.setMessage(message);
        resultVo.setData(null);
        return resultVo;
    }
}
