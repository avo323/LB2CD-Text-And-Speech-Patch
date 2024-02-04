;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1904)
(include sci.sh)
(use Main)
(use Blink)

(public
	Talking_Bear 20
)

(instance Talking_Bear of Talker
	(properties
		x 100
		y 0
		talkWidth 150
		back 15
		name "Talking Bear"
	)
	
	(method (init)
		(= font gFont)
		(super init: &rest)
	)
)
