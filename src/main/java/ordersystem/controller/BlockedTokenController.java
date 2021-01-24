package ordersystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ordersystem.model.BlockedToken;
import ordersystem.service.BlockedTokenService;

/**
 * @author Mian Munawar
 *
 */
@RestController
public class BlockedTokenController {

	@Autowired
	private BlockedTokenService blockedTokenService;
	
	@RequestMapping("/blockedtokens")
	public List<BlockedToken> getAllBlockedTokens() {
		
		return blockedTokenService.getAllBlockedTokens();
	}

	@RequestMapping(method=RequestMethod.POST, value="/invalidatetoken")
	public void invalidateToken(@RequestBody BlockedToken blockedToken) {
		
		blockedTokenService.addBlockedToken(blockedToken);
	}
}
