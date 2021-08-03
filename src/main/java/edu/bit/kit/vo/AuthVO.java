package edu.bit.kit.vo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthVO {

	private int authId;
	private String authAuthority;
	private String authEabled;
	private String userId;

}
